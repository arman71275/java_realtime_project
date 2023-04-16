package com.jrtp.report.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrtp.report.binding.SearchRequest;
import com.jrtp.report.entity.CitizenPlan;
import com.jrtp.report.repository.CitizenPlanRepository;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitizenPlanRepository citizenPlanRepository;

	@Override
	public List<String> getPlanNames() {
		return citizenPlanRepository.getPlanNames();

	}

	@Override
	public List<String> getPlanStatuses() {
		return citizenPlanRepository.getPlanStatuses();
	}

	@Override
	public List<CitizenPlan> getCitizenPlans(SearchRequest searchRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
