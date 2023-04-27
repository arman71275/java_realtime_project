package com.registraion.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class CityMaster {
	@Id
	private Integer cityId;
	private String cityName;
	private Integer stateId;
}
