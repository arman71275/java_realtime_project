package com.jrtp.app.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "CITIZEN_APP")
@Data
public class CitizenAppEntity {
	@Id
	@GeneratedValue
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

}
