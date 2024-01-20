package com.app.dc.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name ="DC_INCOME")
@Data
public class IncomeDetailsEntity {
	@Id
	@GeneratedValue
	private Long incomeId;  //primary key
	private int salaryIncome;
	private Double rentIncome;
	private Double propertyIncome;
	
	//private Integer caseNum; //forignKey reference to DC_CASES

	@OneToOne(targetEntity = DcCaseEntity.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_caseNum",referencedColumnName = "caseNum")
	private DcCaseEntity dcCase;
}
