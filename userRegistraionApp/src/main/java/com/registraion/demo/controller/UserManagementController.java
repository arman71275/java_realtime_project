package com.registraion.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManagementController {

	@GetMapping("/get")
	public String get() {
		return "welcome to userManagementController";	
	}
	
}
