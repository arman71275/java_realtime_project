package com.jrtp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrtp.app.binding.CitizenAppDto;
import com.jrtp.app.service.CitizenRegistrationServie;

@RestController
@RequestMapping("/citizen")
public class CitizenAppController {
	
	@Autowired
	public CitizenRegistrationServie citizenRegistrationServie;
	
	@PostMapping("/post")
	public ResponseEntity<String> citizenRegister(@RequestBody CitizenAppDto citizenAppDto){
		String response = citizenRegistrationServie.registrationCitizen(citizenAppDto);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}

}
