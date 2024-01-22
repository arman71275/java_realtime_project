package com.app.dc.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
//This kidDetailsDto represent only one kid data
public class KidDetailsDto {
	private String kidName;
	private String kidGender;
	private LocalDate kidAge;
	private int kidSsn;
	
	private Summary summary;

}
