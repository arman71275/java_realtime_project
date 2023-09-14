package net.javaguide.organizationservice.mapper;

import net.javaguide.organizationservice.dto.OrganizationDto;
import net.javaguide.organizationservice.entity.Organization;

public class OrganizationMapper {
	
	public static OrganizationDto mapToOrganizationDto(Organization organization) {
		OrganizationDto organizationDto = new OrganizationDto(
				organization.getId(),
				organization.getOrganizationName(),
				organization.getOrganizationDesc(),
				organization.getOrganizationCode(),
				organization.getCreatedDate());
		
		return organizationDto;
	
	}
	
	public static Organization mapToOrganization(OrganizationDto organizationDto) {
		Organization organization = new Organization(
				organizationDto.getId(),
				organizationDto.getOrganizationName(),
				organizationDto.getOrganizationDesc(),
				organizationDto.getOrganizationCode(),
				organizationDto.getCreatedDate());
		return organization;
		
	}

}
