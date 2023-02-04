package com.registraion.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.registraion.demo.entity.UserDetail;
import com.registraion.demo.repository.UserRepository;



public class UserManagementServiceImpl implements UserManagementService{
	
	@Autowired
	public UserRepository userRepository;

	@Override
	public String checkEmail(String email) {
	List<UserDetail> allUsers = userRepository.findAll();
	if(allUsers.contains(email)) {
		return "Email already exists";
	}else
		return "Email not found";
		 
	}

	@Override
	public Map<Integer, String> getCountry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, String> getState(Long countryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, String> getCity(Long stateId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String registerUser(UserDetail userDetail) {
		// TODO Auto-generated method stub
		return null;
	}

}
