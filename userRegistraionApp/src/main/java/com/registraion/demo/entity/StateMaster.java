package com.registraion.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class StateMaster {
	@Id
	private Integer stateId;
	private String stateName;
	private Integer countryId;

}
