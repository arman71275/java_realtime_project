package com.app.dc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dc.entity.PlanEntity;

public interface PlanSelectionRepository extends JpaRepository<PlanEntity, Serializable>{

}
