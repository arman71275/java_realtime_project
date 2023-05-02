package com.app.dc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="DC_EDUCATION")
@Data
public class EducationDetailsEntity {
	
	@Id
	@GeneratedValue
	private long educationId; //primary key
	private String degree;
	private Integer graduationYear;
	private String universityName;
	
	private Integer caseNum;  //forignKey reference DC_CASES

}
