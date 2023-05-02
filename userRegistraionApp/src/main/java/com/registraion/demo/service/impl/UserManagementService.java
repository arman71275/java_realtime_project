package com.registraion.demo.service.impl;

import java.util.Map;

import com.registraion.demo.binding.LoginForm;
import com.registraion.demo.binding.UnlockAccountForm;
import com.registraion.demo.binding.UserForm;
import com.registraion.demo.entity.UserDetail;

public interface UserManagementService {

	public String checkEmail(String email);
	
	public Map<Integer, String> getCountry();
	
	public Map<Integer, String> getState(Integer countryId);
	
	public Map<Integer, String> getCity(Integer stateId);
	
	public String registerUser(UserForm userForm);
	
	public String UnlockAccount(UnlockAccountForm unlockAccountForm);
	
	public String login(LoginForm loginForm);
	
	public String forgotPassword(String email);


}
