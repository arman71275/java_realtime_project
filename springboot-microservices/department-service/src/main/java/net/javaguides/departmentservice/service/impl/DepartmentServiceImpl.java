package net.javaguides.departmentservice.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import net.javaguides.departmentservice.service.DepartmentService;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		Department department = new Department(departmentDto.getId(),departmentDto.getDepartmentName(),departmentDto.getDepartmentDescription(),departmentDto.getDepartmentCode());
		
		Department saveDepartment = departmentRepository.save(department);
		
		DepartmentDto savedDepartmentDto = new DepartmentDto();
		BeanUtils.copyProperties(saveDepartment, savedDepartmentDto);
		return savedDepartmentDto;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {
		Department department = departmentRepository.findByDepartmentCode(departmentCode);
		
		DepartmentDto departmentDto = new DepartmentDto();
		BeanUtils.copyProperties(department, departmentDto);
		
		return departmentDto;
	}

}
