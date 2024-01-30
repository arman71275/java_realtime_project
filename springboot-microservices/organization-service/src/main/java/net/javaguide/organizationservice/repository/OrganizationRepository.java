package net.javaguide.organizationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguide.organizationservice.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long>{

	public Organization findByOrganizationCode(String organizationCode);
}
