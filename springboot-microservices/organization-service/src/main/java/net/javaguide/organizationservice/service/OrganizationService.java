package net.javaguide.organizationservice.service;

import net.javaguide.organizationservice.dto.OrganizationDto;

public interface OrganizationService {
	
	OrganizationDto saveOrganization(OrganizationDto organizationDto);
	
	OrganizationDto getOrganizatinByCode(String organizationCode);

}
