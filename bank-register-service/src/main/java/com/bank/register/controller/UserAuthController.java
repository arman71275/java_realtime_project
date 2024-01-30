package com.bank.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.register.dto.LoginDto;
import com.bank.register.dto.RegisterFormDto;
import com.bank.register.service.UserAuthService;

@RestController
@RequestMapping("/api")
public class UserAuthController {
	
	@Autowired
	private UserAuthService userAuthService;
	
	@PostMapping(value = { "/register", "/signup" }) 
	  public ResponseEntity<String> registerUser(@RequestBody RegisterFormDto registerFormDto) {
	  String response = userAuthService.register(registerFormDto);
	  return new ResponseEntity<>(response, HttpStatus.CREATED); }
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
		String response = userAuthService.login(loginDto);
		return ResponseEntity.ok(response);
	}

}
