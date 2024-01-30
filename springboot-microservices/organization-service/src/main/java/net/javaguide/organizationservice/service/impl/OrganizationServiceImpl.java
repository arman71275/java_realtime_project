package net.javaguide.organizationservice.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguide.organizationservice.dto.OrganizationDto;
import net.javaguide.organizationservice.entity.Organization;
import net.javaguide.organizationservice.mapper.OrganizationMapper;
import net.javaguide.organizationservice.repository.OrganizationRepository;
import net.javaguide.organizationservice.service.OrganizationService;
@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService{

	
	private OrganizationRepository organizationRepository;
	
	@Override
	public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
		//convert OrganizationDto into Organization jpa entity
		Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
		Organization savedOrganization = organizationRepository.save(organization);
		 
		return OrganizationMapper.mapToOrganizationDto(organization);
	}

	@Override
	public OrganizationDto getOrganizatinByCode(String organizationCode) {
		Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
		return OrganizationMapper.mapToOrganizationDto(organization);
	}

}
