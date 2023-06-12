package com.hackacode.marveland.service.impl;

import com.hackacode.marveland.model.dto.request.AdminEmployeeRequestDto;
import com.hackacode.marveland.model.dto.response.AdminEmployeeResponseDto;
import com.hackacode.marveland.model.entity.AdminEmployee;
import com.hackacode.marveland.model.mapper.AdminEmployeeMapper;
import com.hackacode.marveland.repository.AdminEmployeeRepository;
import com.hackacode.marveland.service.IAdminEmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@Service
public class AdminEmployeeServiceImpl implements IAdminEmployeeService {
    @Autowired
	AdminEmployeeRepository adminEmployeeRepository;
	@Autowired
	AdminEmployeeMapper mapper;
	@Override
	public void Update(AdminEmployeeRequestDto requestDto, Long id ) {
		AdminEmployee adminEmployee1 =adminEmployeeRepository.findById(id).orElseThrow(()-> new RuntimeException("This id not exist"));
		AdminEmployee adminEmployee = mapper.update(adminEmployee1,requestDto);
		adminEmployeeRepository.save(adminEmployee);
	}
	@Override
	@Transactional
	public List<AdminEmployee> getAllAdminCustomer() {
		List<AdminEmployee> adminEmployee =adminEmployeeRepository.findAll();
		return adminEmployee;
	}

	@Override
	public List<AdminEmployeeResponseDto> getAllAdmin() {
		List<AdminEmployee> adminEmployees= adminEmployeeRepository.findAll();
		List<AdminEmployeeResponseDto> addList = new ArrayList<>();
		adminEmployees.forEach(adminEmployee -> {
			AdminEmployeeResponseDto responseDto= mapper.fromEntityToDto(adminEmployee);
			addList.add(responseDto);
		} );
		return addList;
	}

	@Override
	public AdminEmployeeResponseDto getById(Long id) {
		AdminEmployee adminEmployee = adminEmployeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Id not Exist!"));
		AdminEmployeeResponseDto responseDto= mapper.fromEntityToDto(adminEmployee);
		return responseDto;
	}

	@Override
	public AdminEmployeeResponseDto getByDni(int dni) {
		return null;
	}

	@Override
	public void delete(Long id) {
	}
}
