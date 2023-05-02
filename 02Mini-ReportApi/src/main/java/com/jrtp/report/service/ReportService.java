package com.jrtp.report.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.jrtp.report.binding.SearchRequest;
import com.jrtp.report.entity.CitizenPlan;
import com.lowagie.text.DocumentException;

public interface ReportService {
public List<String> getPlanNames();
public List<String> getPlanStatuses();
public List<CitizenPlan> getCitizenPlans(SearchRequest searchRequest);
public void exportExcel(HttpServletResponse response) throws Exception;
public void exportPdf(HttpServletResponse response) throws DocumentException, IOException;
}
