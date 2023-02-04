package com.app.dc.service;

import com.app.dc.binding.EducationDetailsDto;
import com.app.dc.binding.IncomeDetailsDto;
import com.app.dc.binding.KidDetailsDto;
import com.app.dc.binding.PlanSelectionDto;
import com.app.dc.entity.PlanSelectionEntity;

public interface DataCollectionService {
	public PlanSelectionDto getPlanName(int appId);
	public String savePlanSelection(PlanSelectionDto planDto);
	public String saveIncomeDetail(IncomeDetailsDto incomeDto);
	public String saveEducationDetail(EducationDetailsDto educationDto);
	public String saveKidDetail(KidDetailsDto kidDto);

}
