package com.bank.register.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bank.register.dto.AccountResponse;



@FeignClient(url = "http://localhost:8080", value = "ACCOUNT-SERVICE")
public interface APIClient {
	
@GetMapping("account/get/{userId}")
public AccountResponse getUserAccount(@PathVariable Long userId);
	
}
