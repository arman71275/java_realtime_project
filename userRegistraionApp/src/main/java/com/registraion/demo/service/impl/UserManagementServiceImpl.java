package com.registraion.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public String checkEmail(String email) {

		List<UserDetail> allUsers = userRepository.findAll();
		if (allUsers.contains(email)) {
			return "Email already exists";
		} else
			return "Email not found";

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

		UserDetail entity = new UserDetail();
		BeanUtils.copyProperties(userForm, entity);
		
		entity.setUserPwd(generateRandomPwd());
		
		entity.setAccStatus("Locked");
		
		userRepository.save(entity);
		return "User Account Created";
	}

	@Override
	public String UnlockAccount(UnlockAccountForm unlockAccountForm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String login(UserForm userForm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String forgotPassword(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	
	private String generateRandomPwd() {
		String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		
		int pwdlength = 6;
		for(int i = 0; i < pwdlength ; i++) {
			int index = random.nextInt(text.length());
			sb.append(text.charAt(index));
		}
		return sb.toString();
	}
}
