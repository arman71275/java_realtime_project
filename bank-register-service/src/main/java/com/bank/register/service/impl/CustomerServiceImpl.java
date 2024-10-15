package com.bank.register.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.register.dto.AccountResponse;
import com.bank.register.dto.RegisterFormDto;
import com.bank.register.dto.UpdateCustomerDto;
import com.bank.register.entity.UserEntity;
import com.bank.register.repository.UserRepository;
import com.bank.register.service.APIClient;
import com.bank.register.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private APIClient apiClient;

	@Override
	public AccountResponse updateProfile(UpdateCustomerDto updateCustomerDto, Long userId) {

		UserEntity existingUser = userRepository.findById(userId).get();

		existingUser.setFirstName(updateCustomerDto.getFirstName());
		existingUser.setLastName(updateCustomerDto.getLastName());
		existingUser.setEmail(updateCustomerDto.getEmail());
		existingUser.setMobileNo(updateCustomerDto.getMobileNo());

		 userRepository.save(existingUser);
		 
		UserEntity user = userRepository.findById(userId).get();

		AccountResponse accountDto = apiClient.getUserAccount(userId);

		AccountResponse accountResponse = new AccountResponse();
		BeanUtils.copyProperties(user, accountResponse);

		return accountResponse;

	}

}
