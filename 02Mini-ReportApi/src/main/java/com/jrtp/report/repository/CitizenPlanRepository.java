package com.jrtp.report.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jrtp.report.entity.CitizenPlan;

@Repository
public interface CitizenPlanRepository extends JpaRepository<CitizenPlan, Serializable> {
	@Query("select distinct(planName) from CitizenPlan")
	public List<String> getPlanNames();

	@Query("select distinct(planStatus) from CitizenPlan")
	public List<String> getPlanStatuses();
}
