package com.registraion.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CountryMaster {
	@Id
	private Integer countryId;
	private String countryName;
}
