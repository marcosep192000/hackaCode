package com.hackacode.marveland.service;

import java.util.List;

import com.hackacode.marveland.model.dto.request.AdminEmployeeRequestDto;
import com.hackacode.marveland.model.dto.response.AdminEmployeeResponseDto;
import com.hackacode.marveland.model.entity.AdminEmployee;

public interface IAdminEmployeeService {

	public void update(AdminEmployeeRequestDto requestDto, Long id);

	public List<AdminEmployee> getAllAdminCustomer();

	public List<AdminEmployeeResponseDto> getAllAdmin();

	public AdminEmployeeResponseDto getById(Long id);

	public AdminEmployeeResponseDto getByDni(int dni);

	public void delete(Long id);
}
