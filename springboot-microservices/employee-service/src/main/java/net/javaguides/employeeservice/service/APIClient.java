package net.javaguides.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.javaguides.employeeservice.dto.DepartmentDto;

//@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERViCE")
@FeignClient(name="DEPARTMENT-SERVICE")
public interface APIClient {
	//build getDepartment rest api
	@GetMapping("/api/departments/{departmentCode}")
	public DepartmentDto getDepartment(@PathVariable String departmentCode);

}
