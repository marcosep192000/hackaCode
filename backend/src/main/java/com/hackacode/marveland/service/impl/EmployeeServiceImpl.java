package com.hackacode.marveland.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hackacode.marveland.model.dto.request.EmployeeRequestDto;
import com.hackacode.marveland.model.dto.response.EmployeeListResponseDto;
import com.hackacode.marveland.model.entity.Employee;
import com.hackacode.marveland.model.mapper.EmployeeMapper;
import com.hackacode.marveland.repository.IEmployeeRepository;
import com.hackacode.marveland.service.IEmployeeService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

	private final EmployeeMapper employeeMapper;

	private final IEmployeeRepository employeeRepository;

	private Employee findEmployeeById(Long id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found"));
	}

	@Override
	public List<EmployeeListResponseDto> getEmployeesByFilters() {
		return employeeRepository.findAll().stream()
				.map(employee -> employeeMapper.fromEntityToDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeListResponseDto getEmployeeById(Long id) {
		Employee Employee = findEmployeeById(id);
		return employeeMapper.fromEntityToDto(Employee);
	}

	@Override
	@Transactional
	public EmployeeListResponseDto updateEmployee(EmployeeRequestDto request, Long id) {
		Employee employee = findEmployeeById(id);
		Employee updatedEmployee = employeeMapper.updateEmployee(employee, request);
		employeeRepository.save(updatedEmployee);
		return employeeMapper.fromEntityToDto(updatedEmployee);
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.delete(findEmployeeById(id));
	}
}