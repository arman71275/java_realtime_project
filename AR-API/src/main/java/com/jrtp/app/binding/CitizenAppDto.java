package com.jrtp.app.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CitizenAppDto {
	private String fname;
	private String email;
	private String mobileNo;
	private String gender;
	private LocalDate dob;
	private long ssn;
	//private Integer createdById;
	//private Integer updatedById;

}
