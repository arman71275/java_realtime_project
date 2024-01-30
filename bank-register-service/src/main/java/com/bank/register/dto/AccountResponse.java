package com.bank.register.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import com.bank.register.entity.Account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {
	private Long userId;
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNo;
	private String username;
	private List<Account> account;

}
