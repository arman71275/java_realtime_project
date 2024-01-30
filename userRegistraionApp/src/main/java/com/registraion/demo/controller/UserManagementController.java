package com.registraion.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.registraion.demo.binding.LoginForm;
import com.registraion.demo.binding.UnlockAccountForm;
import com.registraion.demo.binding.UserForm;
import com.registraion.demo.entity.UserDetail;
import com.registraion.demo.repository.UserRepository;
import com.registraion.demo.service.impl.UserManagementService;

@RestController
public class UserManagementController {

	@Autowired
	private UserManagementService userManagementService;

	@GetMapping("/country")
	public Map<Integer, String> loadCountries() {
		return userManagementService.getCountry();
	}

	@GetMapping("/state/{countryId}")
	public Map<Integer, String> loadStates(@PathVariable Integer countryId) {
		return userManagementService.getState(countryId);
	}

	@GetMapping("/city/{stateId}")
	public Map<Integer, String> loadCities(@PathVariable Integer stateId) {
		return userManagementService.getCity(stateId);
	}

	@PostMapping("/register")
	public String userRegistration(@RequestBody UserForm userForm) {
		return userManagementService.registerUser(userForm);

	}

	@GetMapping("check/{email}")
	public ResponseEntity<String> checkEmail(@PathVariable String email) {
		String result = userManagementService.checkEmail(email);
		return new ResponseEntity<>(result, HttpStatus.OK);

	}

	@PostMapping("/unlock")
	public ResponseEntity<String> unlockAccount(@RequestBody UnlockAccountForm unlockAccountForm) {
		String unlockAccount = userManagementService.UnlockAccount(unlockAccountForm);
		return new ResponseEntity<>(unlockAccount, HttpStatus.OK);

	}

	@PostMapping("login")
	public ResponseEntity<String> loginAccount(@RequestBody LoginForm loginForm) {
		String status = userManagementService.login(loginForm);
		return new ResponseEntity<>(status, HttpStatus.OK);

	}

	@GetMapping("/forgot/{email}")
	public ResponseEntity<String> forgotPassword(@PathVariable String email) {
		String forgotPassword = userManagementService.forgotPassword(email);
		return new ResponseEntity<>(forgotPassword, HttpStatus.OK);
	}

}
