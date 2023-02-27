package com.app.dc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.dc.binding.PlanSelectionDto;
import com.app.dc.service.DataCollectionService;

@RestController
public class DataCollelctionController {
	@Autowired
	private DataCollectionService dataCollectionService;
	
	@GetMapping("/createCase/{appId}")
	public ResponseEntity<PlanSelectionDto> caseCreation(@PathVariable long appId){
		PlanSelectionDto planSelectionResponse = dataCollectionService.createCasse(appId);
		return new ResponseEntity<>(planSelectionResponse,HttpStatus.OK);
	}
	

}
