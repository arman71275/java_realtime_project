package com.registraion.demo.service.impl;

import java.util.Map;

import com.registraion.demo.entity.UserDetail;

public interface UserManagementService {

	public String checkEmail(String email);
	public Map<Integer, String> getCountry();
	public Map<Integer, String> getState(Long countryId);
	public Map<Integer, String> getCity(Long stateId);
	public String registerUser(UserDetail userDetail);

}
