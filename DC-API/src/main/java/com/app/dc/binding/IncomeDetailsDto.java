package com.app.dc.binding;

import lombok.Data;

@Data
public class IncomeDetailsDto {
	private int monthlyIncome;
	private int rentIncome;
	private int propertyIncome;
	
	private long caseNumber;

}
