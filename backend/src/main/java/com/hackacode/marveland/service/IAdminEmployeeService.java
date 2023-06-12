package com.hackacode.marveland.service;

import com.hackacode.marveland.model.dto.request.AdminEmployeeRequestDto;
import com.hackacode.marveland.model.dto.response.AdminEmployeeResponseDto;
import com.hackacode.marveland.model.entity.AdminEmployee;

import java.util.List;

public interface IAdminEmployeeService {

	void Update(AdminEmployeeRequestDto requestDto, Long id);
	public List<AdminEmployee> getAllAdminCustomer();
	public List<AdminEmployeeResponseDto> getAllAdmin();
	public AdminEmployeeResponseDto getById(Long id);

	public AdminEmployeeResponseDto getByDni(int dni);

	public void delete(Long id);

}
