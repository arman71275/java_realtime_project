package net.javaguides.employeeservice.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.APIResponseDto;
import net.javaguides.employeeservice.dto.DepartmentDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.dto.OrganizationDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.APIClient;
import net.javaguides.employeeservice.service.EmployeeService;
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	//private RestTemplate restTemplate;
	
	private WebClient webClient;
	
	private APIClient apiClient;

	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDto, employee);
		Employee savedEmployee = employeeRepository.save(employee);
		
		EmployeeDto savedEmployeeDto = new EmployeeDto();
		BeanUtils.copyProperties(savedEmployee, savedEmployeeDto);
		
		return savedEmployeeDto;
	}

	@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	@Override
	public APIResponseDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).get();
		
		//fetching departemnt info from url in employee service
	//	ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
	//	DepartmentDto departmentDto = responseEntity.getBody();
		
	//	DepartmentDto departmentDto = webClient.get().uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
	//	.retrieve().bodyToMono(DepartmentDto.class).block();
		
		DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
		
		EmployeeDto employeeDto = new EmployeeDto();
		BeanUtils.copyProperties(employee, employeeDto);
		
		//fetching organization info from url in employee service
		OrganizationDto organizationDto = webClient.get().uri("http://localhost:8083/api/organization/" + employee.getOrganizationCode())
				.retrieve().bodyToMono(OrganizationDto.class).block();
		
		//setting departmentDto and employeeDto in APIResponseDto class and returning
		APIResponseDto apiResponeDto = new APIResponseDto();
		apiResponeDto.setEmployeeDto(employeeDto);
		apiResponeDto.setDepartmentDto(departmentDto);
		apiResponeDto.setOrganizationDto(organizationDto);
		
		return apiResponeDto;
	}
	
	
	public APIResponseDto getDefaultDepartment(Long employeeId, Exception exception) {
		Employee employee = employeeRepository.findById(employeeId).get();
		
		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setDepartmentName("R & D");
		departmentDto.setDepartmentCode("RD001");
		departmentDto.setDepartmentDescription("Research and Development");
		
		
		EmployeeDto employeeDto = new EmployeeDto();
		BeanUtils.copyProperties(employee, employeeDto);
		
		APIResponseDto apiResponeDto = new APIResponseDto();
		apiResponeDto.setEmployeeDto(employeeDto);
		apiResponeDto.setDepartmentDto(departmentDto);
		
		return apiResponeDto;
		
	}

}
