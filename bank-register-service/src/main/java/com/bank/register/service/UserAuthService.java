package com.bank.register.service;

import com.bank.register.dto.LoginDto;
import com.bank.register.dto.RegisterFormDto;

public interface UserAuthService {

	String register(RegisterFormDto registerFormDto);
	String login(LoginDto loginDto);

}
