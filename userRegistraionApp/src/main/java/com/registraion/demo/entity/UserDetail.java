package com.registraion.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class UserDetail {
	@Id
	@GeneratedValue
	private long userId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNo;
	private Date dob;
	private String gender;
	private String country;
	private String state;
	private String city;
	private String UserPwd;
	private String accStatus;
}
