package com.hackacode.marveland.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hackacode.marveland.model.dto.request.EmployeeRequestDto;
import com.hackacode.marveland.model.dto.response.AdminEmployeeResponseDto;
import com.hackacode.marveland.model.entity.AdminEmployee;
import com.hackacode.marveland.model.entity.Employee;
import com.hackacode.marveland.model.mapper.EmployeeMapper;
import com.hackacode.marveland.repository.IAdminEmployeeRepository;
import com.hackacode.marveland.service.IEmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

	private final IAdminEmployeeRepository adminEmployeeRepository;

	private final EmployeeMapper mapper;

	@Override
	public List<AdminEmployeeResponseDto> getAllEmployees() {
		List<AdminEmployee> adminEmployees = adminEmployeeRepository.findAll();
		List<AdminEmployeeResponseDto> addList = new ArrayList<>();
		adminEmployees.forEach(adminEmployee -> {
			AdminEmployeeResponseDto responseDto = mapper.fromEntityToDto(adminEmployee);
			addList.add(responseDto);
		});
		return addList;
	}

	@Override
	public List<Employee> getEmployeesByFilters() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getEmployeesByFilters'");
	}

	@Override
	public AdminEmployeeResponseDto getEmployeeById(Long id) {
		AdminEmployee adminEmployee = adminEmployeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Id not Exist!"));
		AdminEmployeeResponseDto responseDto = mapper.fromEntityToDto(adminEmployee);
		return responseDto;
	}


	@Override
	public void updateEmployee(EmployeeRequestDto requestDto, Long id) {
		AdminEmployee adminEmployee1 = adminEmployeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("This id not exist"));
		AdminEmployee adminEmployee = mapper.update(adminEmployee1, requestDto);
		adminEmployeeRepository.save(adminEmployee);
	}

	@Override
	public void deleteEmployee(Long id) {
	}
}
