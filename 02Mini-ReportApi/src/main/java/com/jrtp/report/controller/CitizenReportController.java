package com.jrtp.report.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrtp.report.binding.SearchRequest;
import com.jrtp.report.entity.CitizenPlan;
import com.jrtp.report.service.ReportService;

@RestController
@RequestMapping("/citizen")
public class CitizenReportController {
	
	@Autowired
	private ReportService reportService;

	@GetMapping("/getPlans")
	public ResponseEntity<List<String>> getplanList() {
		List<String> planNames = reportService.getPlanNames();
		return new ResponseEntity<>(planNames, HttpStatus.OK);
	}

	@GetMapping("/getStatus")
	public ResponseEntity<List<String>> getPlanStatusList() {
		List<String> planStatuses = reportService.getPlanStatuses();
		return ResponseEntity.ok(planStatuses);
		
		
	}
	@GetMapping("/excel")
	public void generateExcelReport(HttpServletResponse response) throws Exception{
		
		response.setContentType("application/octet-stream");
		
		String headerKey = "Content-Dispositioin";
		String headerValue = "attachment;filename=citizens.xlsx";

		response.setHeader(headerKey, headerValue);
		
		reportService.exportExcel(response);
				
	}
	
	@GetMapping("/pdf")
	public void generatePdfReport(HttpServletResponse response) throws Exception{
		
		response.setContentType("application/pdf");

		String key = "Content-Disposition";
		String value = "attachment;filename=plans.pdf";

		response.setHeader(key, value);

		reportService.exportPdf(response);

		response.flushBuffer();
	}
		

}
