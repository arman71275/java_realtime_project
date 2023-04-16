package com.app.dc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="PLAN_MASTER")  //for dropdown
@Data
public class PlanEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer planId;   //primaryKey
	private String planName;
	
	//private Integer caseNum; //forignKey reference to DC_CASES
	
	@OneToOne(mappedBy = "planEntity")
	private DcCaseEntity dcCaseEntity;
}
