package com.app.dc.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="DC_CASES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DcCaseEntity{
	@Id
	@GeneratedValue
	private Integer caseNum;  //primary key
	
	//private Long planId;  //forignkey reference PLAN_MASTER
	@OneToOne(targetEntity = PlanEntity.class,cascade = CascadeType.ALL)
	@JoinColumn(name="fk_planId",referencedColumnName = "planId")
	private PlanEntity planEntity;
	
	//private Long appId;  //forignKey reference CITIZEN_APPS
	@OneToOne(targetEntity =CitizenAppEntity.class,cascade = CascadeType.ALL)
	@JoinColumn(name="fk_appId",referencedColumnName = "appId")
	private CitizenAppEntity citizenAppEntity;
	

}
