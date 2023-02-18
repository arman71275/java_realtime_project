package com.app.dc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="DC_CASES")
@Data
public class DcCaseEntity{
	@Id
	@GeneratedValue
	private Integer caseNum;  //primary key
	
	private long planId;  //forignkey reference PLAN_MASTER
	
	private Integer appId;  //forignKey reference CITIZEN_APPS

}
