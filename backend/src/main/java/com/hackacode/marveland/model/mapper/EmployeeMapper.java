package com.hackacode.marveland.model.mapper;

import org.springframework.stereotype.Component;

import com.hackacode.marveland.model.dto.request.EmployeeRequestDto;
import com.hackacode.marveland.model.dto.response.EmployeeListResponseDto;
import com.hackacode.marveland.model.entity.Employee;

@Component
public class EmployeeMapper {

	public EmployeeListResponseDto fromEntityToDto(Employee employee) {
		EmployeeListResponseDto response = new EmployeeListResponseDto();
		response.setId(employee.getId());
		response.setFirstName(employee.getFirstName());
		response.setLastName(employee.getLastName());
		response.setDni(employee.getDni());
		response.setEmail(employee.getEmail());
		response.setRegistrationDate(employee.getRegistrationDate());
		response.setWorkingHours(employee.getWorkingHours());
		return response;
	}

	public Employee update(Employee employee, EmployeeRequestDto request) {
		employee.setFirstName(request.getFirstName());
		employee.setLastName(request.getLastName());
		employee.setDni(request.getDni());
		employee.setEmail(request.getEmail());
		employee.setWorkingHours(request.getWorkingHours());
		return employee;
	}
}
