package net.javaguides.employeeservice.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {
	private Long id;
	private String organizationName;
	private String organizationDesc;
	private String organizationCode;
	private LocalDateTime createdDate;

}
