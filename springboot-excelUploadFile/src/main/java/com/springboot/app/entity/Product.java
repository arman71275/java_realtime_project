package com.springboot.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long SerialNo;
	
	private Date date;
	private String customerName;
	
	private Long mobileNo;
	
	private String chasisNo;
	
	private String registrationNo;
	
	
	  private String rtoOffice;
	  /* 
	 * private String address;
	 * 
	 * private String ownerName;
	 * 
	 * private String payment;
	 * 
	 * private String taxValid;
	 * 
	 * private String pollutionValid;
	 * 
	 * private String insuranceValid;
	 * 
	 * private String fitnessValid;
	 * 
	 * private String permitValid;
	 */

}
