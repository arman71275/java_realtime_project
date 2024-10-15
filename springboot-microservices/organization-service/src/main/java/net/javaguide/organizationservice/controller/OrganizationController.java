package net.javaguide.organizationservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.javaguide.organizationservice.dto.OrganizationDto;
import net.javaguide.organizationservice.service.OrganizationService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/organization")
public class OrganizationController {
	
	private OrganizationService organizationService;

	@PostMapping
	public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
		OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);
		return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
		
	}
	@GetMapping("/{code}")
	public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode){
		OrganizationDto organizatinDto = organizationService.getOrganizatinByCode(organizationCode);
	return ResponseEntity.ok(organizatinDto);
	}
	
	
}
