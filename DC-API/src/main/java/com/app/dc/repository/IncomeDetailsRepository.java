package com.app.dc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dc.entity.IncomeDetailsEntity;

public interface IncomeDetailsRepository extends JpaRepository<IncomeDetailsEntity, Serializable>{

}
