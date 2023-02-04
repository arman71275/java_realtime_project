package com.app.dc.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="PLAN_SELECTION")
@Data
public class PlanSelectionEntity {
	@Id
	@GeneratedValue
	private long caseNo;
	private String planName;
}
