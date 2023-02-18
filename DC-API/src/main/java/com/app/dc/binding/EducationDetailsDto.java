package com.app.dc.binding;

import java.util.Date;

import lombok.Data;
@Data
public class EducationDetailsDto {
	private String degree;
	private Date date;
	private String university;
	
	private long caseNumber;

}
