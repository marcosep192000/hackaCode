package com.hackacode.marveland.service;

import com.hackacode.marveland.model.dto.request.AdminEmployeeRequestDto;
import com.hackacode.marveland.model.dto.response.AdminEmployeeResponseDto;
import com.hackacode.marveland.model.dto.response.GameResponseDto;
import com.hackacode.marveland.model.entity.AdminEmployee;

import java.util.List;

public interface IAdminEmployeeService {
	void create(AdminEmployeeRequestDto requestDto);
	void Update(AdminEmployeeRequestDto requestDto, AdminEmployee adminEmployee);

	public List<AdminEmployeeResponseDto> getAll();

	public AdminEmployeeResponseDto getById(Long id);

	public void delete(Long id);

}
