package com.bank.register.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateCustomerDto {
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNo;

}
