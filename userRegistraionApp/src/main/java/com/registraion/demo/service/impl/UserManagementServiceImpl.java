package com.registraion.demo.service.impl;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registraion.demo.binding.LoginForm;
import com.registraion.demo.binding.UnlockAccountForm;
import com.registraion.demo.binding.UserForm;
import com.registraion.demo.entity.CityMaster;
import com.registraion.demo.entity.CountryMaster;
import com.registraion.demo.entity.StateMaster;
import com.registraion.demo.entity.UserDetail;
import com.registraion.demo.repository.CityRepository;
import com.registraion.demo.repository.CountryRepository;
import com.registraion.demo.repository.StateRepository;
import com.registraion.demo.repository.UserRepository;
import com.registraion.demo.util.EmailUtils;

@Service
public class UserManagementServiceImpl implements UserManagementService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private EmailUtils emailUtils;

	@Override
	public String checkEmail(String email) {

		UserDetail user = userRepository.findByEmail(email);

		if (user == null) {
			return "UNIQUE";
		}
		return "Already registerd user.";
	}

	@Override
	public Map<Integer, String> getCountry() {
		List<CountryMaster> countryList = countryRepository.findAll();

		Map<Integer, String> countryMap = new HashMap<>();
		countryList.forEach(country -> countryMap.put(country.getCountryId(), country.getCountryName()));
		return countryMap;
		/*
		 * //OR Map<Integer, String> countryMap = countryList.stream()
		 * .collect(Collectors.toMap(CountryMaster::getCountryId,
		 * CountryMaster::getCountryName)); return countryMap;
		 */
	}

	@Override
	public Map<Integer, String> getState(Integer countryId) {

		List<StateMaster> findByCountryId = stateRepository.findByCountryId(countryId);

		Map<Integer, String> stateMap = new HashMap<>();
		findByCountryId.forEach(state -> stateMap.put(state.getStateId(), state.getStateName()));
		return stateMap;
	}

	@Override
	public Map<Integer, String> getCity(Integer stateId) {
		List<CityMaster> findByStateId = cityRepository.findByStateId(stateId);

		Map<Integer, String> cityMap = new HashMap<>();
		findByStateId.forEach(state -> cityMap.put(state.getCityId(), state.getCityName()));
		return cityMap;
	}

	@Override
	public String registerUser(UserForm userForm) {
		//String checkEmailId = checkEmailId(userForm.getEmail());
		
		UserDetail entity = new UserDetail();
		BeanUtils.copyProperties(userForm, entity);

		entity.setUserPwd(generateRandomPwd());

		entity.setAccStatus("Locked");

		userRepository.save(entity);
		
		// TODO : Send Email to unlock account
		String from = "armani71275@gmail.com";
		String to = userForm.getEmail();
		String subject = "Registration Email";
		String body = readEmailBody("REG_EMAIL_BODY.html", entity);
System.out.println("body::" + body + subject + "To::" + to);
        emailUtils.sendEmail(from, to, subject, body);

		return "User Account Created";
	}

	

	@Override
	public String UnlockAccount(UnlockAccountForm unlockAccountForm) {
		UserDetail user = userRepository.findByEmail(unlockAccountForm.getEmail());

		if (unlockAccountForm.getTempPwd().equals(user.getUserPwd())) {
			user.setUserPwd(unlockAccountForm.getNewPwd());
			user.setAccStatus("UNLOCKED");
			userRepository.save(user);
			System.out.println("user::"+ user);
			return "Account unlocked, please proceed with login";
		}
		return "Please Enter Correct Password";
	}

	@Override
	public String login(LoginForm loginForm) {
		UserDetail user = userRepository.findByEmailAndUserPwd(loginForm.getEmail(),loginForm.getPwd());

		if (user == null ) {
			return "Invalid Credentials!";

		}
		if (user.getAccStatus().equals("LOCKED")) {
			return "User is locked!.";
		}
		return "login success..";
	}

	@Override
	public String forgotPassword(String email) {
		UserDetail user = userRepository.findByEmail(email);
		
		if (user == null) {
			return "No Account Found";
		}

		String from = "armani71275@gmail.com";
		String subject = "Recover Password";
		String body = readEmailBody("FORGOT_PWD_EMAIL_BODY.txt", user);

		emailUtils.sendEmail(from,email, subject, body);

		return "Password sent to registered email";
	}

	
	
	private String generateRandomPwd() {
		String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuffer sb = new StringBuffer();
		Random random = new Random();

		int pwdlength = 6;
		for (int i = 0; i < pwdlength; i++) {
			int index = random.nextInt(text.length());
			sb.append(text.charAt(index));
		}
		return sb.toString();
	}
	
	
	private String checkEmailId(String email) {

		UserDetail user = userRepository.findByEmail(email);

		if (user == null) {
			return "UNIQUE";
		}
		return "Already registerd user.";
	}
	
	private String readEmailBody(String filename, UserDetail user) {
		StringBuilder sb = new StringBuilder();
		try (Stream<String> lines = Files.lines(Paths.get(filename))) {
			lines.forEach(line -> {
				line = line.replace("${FNAME}", user.getFirstName());
				line = line.replace("${LNAME}", user.getLastName());
				line = line.replace("${TEMP_PWD}", user.getUserPwd());
				line = line.replace("${EMAIL}", user.getEmail());
				line = line.replace("${PWD}", user.getUserPwd());
				sb.append(line);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
