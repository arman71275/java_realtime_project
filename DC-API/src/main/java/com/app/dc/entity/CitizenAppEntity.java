package com.app.dc.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "CITIZEN_APP")
@Data
public class CitizenAppEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long appId;   
	private String fname;
	private String email;
	private String mobileNo;
	private String gender;
	private LocalDate dob;
	private long ssn;

	@CreationTimestamp
	private LocalDate createdDate;
	@UpdateTimestamp
	private LocalDate updatedDate;

	private Integer createdById;
	private Integer updatedById;
	
	/*
	 * @OneToOne(mappedBy = "citizenAppEntity") private DcCaseEntity dcCaseEntity;
	 */
	
	

}
