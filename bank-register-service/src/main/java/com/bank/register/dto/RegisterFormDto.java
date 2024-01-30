package com.bank.register.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterFormDto {
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNo;
	private String username;
	private String password;

}
