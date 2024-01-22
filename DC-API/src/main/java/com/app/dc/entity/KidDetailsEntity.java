package com.app.dc.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="DC_KIDS")
@Data
public class KidDetailsEntity {
	@Id
	@GeneratedValue
	private long kidId; //primaryKey
	private String kidName;
	private LocalDate kidDob;
	private String kidGender;
	private long kidSsn;
	
	//private Integer caseNum;  //forignKey reference DC_CASES
	
	@OneToOne(targetEntity = DcCaseEntity.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_caseNum",referencedColumnName = "caseNum")
	private DcCaseEntity dcCaseEntity;

}
