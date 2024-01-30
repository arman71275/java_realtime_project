package com.app.dc.binding;

import lombok.Data;

@Data
public class IncomeDetailsDto {
	private int salaryIncome;
	private Double rentIncome;
	private Double propertyIncome;
	
	private Long caseNumber;

}
