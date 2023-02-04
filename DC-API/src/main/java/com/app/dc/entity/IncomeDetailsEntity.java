package com.app.dc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="INCOME_DETAILS")
public class IncomeDetailsEntity {
	@Id
	@GeneratedValue
	private long caseNo;
	private int monthlyIncome;
	private int rentIncome;
	private int propertyIncome;

}
