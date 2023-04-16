package com.jrtp.report.service;

import java.util.List;

import com.jrtp.report.binding.SearchRequest;
import com.jrtp.report.entity.CitizenPlan;

public interface ReportService {
public List<String> getPlanNames();
public List<String> getPlanStatuses();
public List<CitizenPlan> getCitizenPlans(SearchRequest searchRequest);
}
