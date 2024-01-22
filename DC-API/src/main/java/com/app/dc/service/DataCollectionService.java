package com.app.dc.service;

import com.app.dc.binding.EducationDetailsDto;
import com.app.dc.binding.IncomeDetailsDto;
import com.app.dc.binding.KidDetailsDto;
import com.app.dc.binding.KidInfo;
import com.app.dc.binding.PlanSelectionDto;
import com.app.dc.binding.Summary;
import com.app.dc.entity.PlanEntity;

public interface DataCollectionService {
	public PlanSelectionDto createCasse(long appId);
	public Long updatePlanSelection(PlanSelectionDto planDto);  //return caseNum as response
	
	public Long saveIncomeDetail(IncomeDetailsDto incomeDto); //return caseNum as response
	
	public Long saveEducationDetail(EducationDetailsDto educationDto);   //return caseNum as response
	public Summary saveKidDetail(KidInfo kidInfo);    //summary sent in UI
	

}
