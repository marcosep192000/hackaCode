package com.hackacode.marveland.service.impl;

import com.hackacode.marveland.model.dto.request.AdminEmployeeRequestDto;
import com.hackacode.marveland.model.dto.response.AdminEmployeeResponseDto;
import com.hackacode.marveland.model.entity.AdminEmployee;
import com.hackacode.marveland.service.IAdminEmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminEmployeeServiceImpl implements IAdminEmployeeService {
	@Override
	public void create(AdminEmployeeRequestDto requestDto) {

	}

	@Override
	public void Update(AdminEmployeeRequestDto requestDto, AdminEmployee adminEmployee) {
	}

	@Override
	public List<AdminEmployeeResponseDto> getAll() {
		return null;
	}

	@Override
	public AdminEmployeeResponseDto getById(Long id) {
		return null;
	}

	@Override
	public void delete(Long id) {
	}
}
