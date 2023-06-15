package com.hackacode.marveland.service;

import java.util.List;

import com.hackacode.marveland.model.dto.request.AdminEmployeeRequestDto;
import com.hackacode.marveland.model.dto.response.AdminEmployeeResponseDto;
import com.hackacode.marveland.model.entity.Employee;

public interface IEmployeeService {

	public List<AdminEmployeeResponseDto> getAllEmployees();

	public AdminEmployeeResponseDto getEmployeeById(Long id);

	public List<Employee> getEmployeesByFilters();

	public void updateEmployee(AdminEmployeeRequestDto requestDto, Long id);

	public void deleteEmployee(Long id);
}
