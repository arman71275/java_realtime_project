package com.app.dc.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="EDUCATION_DETAILS")
public class EducationDetailsEntity {
	
	@Id
	@GeneratedValue
	private long caseNo;
	private String degree;
	private Date date;
	private String university;

}
