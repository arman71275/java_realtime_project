package com.jrtp.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
