package com.app.dc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class KidDetailsEntity {
	@Id
	@GeneratedValue
	private long caseNo;
	private String kidName;
	private int kidAge;
	private int ssn;
	
	

}
