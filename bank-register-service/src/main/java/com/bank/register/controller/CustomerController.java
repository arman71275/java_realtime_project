package com.bank.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.register.dto.AccountResponse;
import com.bank.register.dto.UpdateCustomerDto;
import com.bank.register.entity.UserEntity;
import com.bank.register.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	 @PutMapping("/update/{userId}")
	  public ResponseEntity<AccountResponse> updateCountry(@RequestBody UpdateCustomerDto updateCustomerDto, @PathVariable Long userId){
		  AccountResponse response = customerService.updateProfile(updateCustomerDto, userId);
		return ResponseEntity.ok().body(response);
	  }
	 
}
