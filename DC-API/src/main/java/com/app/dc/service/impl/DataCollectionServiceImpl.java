package com.app.dc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dc.binding.EducationDetailsDto;
import com.app.dc.binding.IncomeDetailsDto;
import com.app.dc.binding.KidDetailsDto;
import com.app.dc.binding.KidInfo;
import com.app.dc.binding.PlanSelectionDto;
import com.app.dc.binding.Summary;
import com.app.dc.entity.CitizenAppEntity;
import com.app.dc.entity.DcCaseEntity;
import com.app.dc.entity.EducationDetailsEntity;
import com.app.dc.entity.IncomeDetailsEntity;
import com.app.dc.entity.KidDetailsEntity;
import com.app.dc.entity.PlanEntity;
import com.app.dc.repository.CitizenAppRepository;
import com.app.dc.repository.DcCaseRepository;
import com.app.dc.repository.EducationDetailsRepository;
import com.app.dc.repository.IncomeDetailsRepository;
import com.app.dc.repository.KidDetailsRepository;
import com.app.dc.repository.PlanSelectionRepository;
import com.app.dc.service.DataCollectionService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class DataCollectionServiceImpl implements DataCollectionService{
	
	@Autowired
	private CitizenAppRepository citizenAppRepository;
	
	@Autowired
	private DcCaseRepository dcCaseRepository;
	
	@Autowired 
	private EducationDetailsRepository educationDetailsRepository;
	@Autowired
	private IncomeDetailsRepository incomeDetailsRepository;
	@Autowired
	private PlanSelectionRepository planSelectionRepository;
	@Autowired
	private KidDetailsRepository kidDetailsRepository;
	
	
	@Override
	@Transactional
	public PlanSelectionDto createCasse(long appId) {
		PlanSelectionDto planSelection = new PlanSelectionDto();
		
		Optional<CitizenAppEntity> planById=  citizenAppRepository.findById(appId);
		log.info("DataCollectionService::createCasse request appId {}",appId);
		if(planById.isPresent()) {
			//create case 
			DcCaseEntity caseEntity = new DcCaseEntity();
			CitizenAppEntity citizenAppEntity = planById.get();
			System.out.println("citizenAppEntity:;"+citizenAppEntity);
			
			caseEntity.setCitizenApp(citizenAppEntity);
			dcCaseRepository.save(caseEntity);
			
			//fetching plan names for dropdown
			List<PlanEntity> planList = planSelectionRepository.findAll();
			
			Map<Long, String> planMap = new HashMap<>();
			planList.forEach(plan -> {
				planMap.put(plan.getPlanId(), plan.getPlanName());
			});
			
			//preparing response data
			planSelection.setCaseNum(caseEntity.getCaseNum());
			planSelection.setPlanInfo(planMap);
			
			return planSelection ;
		}
		return planSelection;
		
	}

	@Override
	public Long updatePlanSelection(PlanSelectionDto planDto) {
		long planNumber = planDto.getPlanId();
		long caseNumber=  planDto.getCaseNum();
		
		Optional<DcCaseEntity>  findByCase= dcCaseRepository.findById(caseNumber);
		log.info("DataCollectionService::updatePlan request caseNum {}",caseNumber);
		
		if(findByCase.isPresent()) {	
			DcCaseEntity dcCaseEntity = findByCase.get();
			
			// Fetch the associated PlanEntity
			 PlanEntity planEntity = planSelectionRepository.findById(planNumber)
		                .orElseThrow(() -> new EntityNotFoundException("PlanEntity not found with id: " + planNumber));

			// Update the association
		        dcCaseEntity.setPlan(planEntity);
		
		     // Save the owning entity
			dcCaseRepository.save(dcCaseEntity);
		}
		
		return caseNumber;
	}


	@Override
	public Long saveIncomeDetail(IncomeDetailsDto incomeDto) {
		long caseNo = incomeDto.getCaseNumber();
		
		IncomeDetailsEntity entity = new IncomeDetailsEntity();
		BeanUtils.copyProperties(incomeDto, entity);
		
		incomeDetailsRepository.save(entity );
		
		return caseNo;
	}


	@Override
	public Long saveEducationDetail(EducationDetailsDto educationDto) {
		long caseNo = educationDto.getCaseNumber();
		
		EducationDetailsEntity educationEntity = new EducationDetailsEntity();
		BeanUtils.copyProperties(educationDto, educationEntity);
		educationDetailsRepository.save(educationEntity);
		
		return caseNo;
	}


	@Override
	public Summary saveKidDetail(KidInfo kidInfo) {
		long caseNumber = kidInfo.getCaseNumber();
		
		 List<KidDetailsDto> kidList = kidInfo.getKids();
		//This is used to store one kid but this time have multiple data //KidDetailsEntity kidEntity = new KidDetailsEntity();
		List<KidDetailsEntity> kidEntities = new ArrayList<>();
		 
		 kidList.forEach(kid -> {
			 KidDetailsEntity kidEntity = new KidDetailsEntity();
			 BeanUtils.copyProperties(kid, kidEntity);
			 kidEntities.add(kidEntity);
			 
		 });
		 kidDetailsRepository.saveAll(kidEntities);
		
		return null;
	}
	
	

}
