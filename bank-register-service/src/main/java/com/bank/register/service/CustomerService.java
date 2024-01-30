package com.bank.register.service;

import com.bank.register.dto.AccountResponse;
import com.bank.register.dto.RegisterFormDto;
import com.bank.register.dto.UpdateCustomerDto;
import com.bank.register.entity.UserEntity;

public interface CustomerService {
	

	AccountResponse updateProfile(UpdateCustomerDto updateCustomerDto, Long userId);


}
