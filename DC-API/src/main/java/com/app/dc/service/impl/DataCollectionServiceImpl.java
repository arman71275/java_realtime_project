package com.app.dc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dc.binding.EducationDetailsDto;
import com.app.dc.binding.IncomeDetailsDto;
import com.app.dc.binding.KidDetailsDto;
import com.app.dc.binding.PlanSelectionDto;
import com.app.dc.entity.PlanSelectionEntity;
import com.app.dc.repository.EducationDetailsRepository;
import com.app.dc.repository.IncomeDetailsRepository;
import com.app.dc.repository.KidDetailsRepository;
import com.app.dc.repository.PlanSelectionRepository;
import com.app.dc.service.DataCollectionService;
@Service
public class DataCollectionServiceImpl implements DataCollectionService{
	
	@Autowired
	public EducationDetailsRepository educationDetailsRepository;
	@Autowired
	public IncomeDetailsRepository incomeDetailsRepository;
	@Autowired
	public PlanSelectionRepository planSelectionRepository;
	@Autowired
	public KidDetailsRepository kidDetailsRepository;
	
	
	@Override
	public PlanSelectionDto getPlanName(int appId) {
		Optional<PlanSelectionEntity> planList=  planSelectionRepository.findById(appId);
		
		if(!planList.isPresent()) {
			for(PlanSelectionEntity planSelectionEntity : planList)
			return PlanSelectionDto.builder().appId(planSelectionEntity.getCaseNo()).planName(planSelectionEntity.getPlanName()).build();
		}
		return PlanSelectionDto.builder().build();
	}
	
	@Override
	public String savePlanSelection(PlanSelectionDto planDto) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String saveIncomeDetail(IncomeDetailsDto incomeDto) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String saveEducationDetail(EducationDetailsDto educationDto) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String saveKidDetail(KidDetailsDto kidDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
