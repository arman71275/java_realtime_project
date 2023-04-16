package com.jrtp.report.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
//@Table(name="CITIZEN_PLANS_INFO")
@Data
public class CitizenPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	private String cname;
	private String email;
	private String mobileNo;
	private String gender;
	private String ssn;
	private String planName;
	private String planStatus;
	private Date startDate;
	private Date endDate;

}
