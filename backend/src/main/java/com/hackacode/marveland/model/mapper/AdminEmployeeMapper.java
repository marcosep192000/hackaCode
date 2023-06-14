package com.hackacode.marveland.model.mapper;

import org.springframework.stereotype.Component;

import com.hackacode.marveland.model.dto.request.AdminEmployeeRequestDto;
import com.hackacode.marveland.model.dto.response.AdminEmployeeResponseDto;
import com.hackacode.marveland.model.entity.AdminEmployee;

@Component
public class AdminEmployeeMapper {

	public AdminEmployeeResponseDto fromEntityToDto(AdminEmployee adminEmployee) {
		AdminEmployeeResponseDto responseDto = new AdminEmployeeResponseDto();
		responseDto.setId(adminEmployee.getId());
		responseDto.setFirstName(adminEmployee.getFirstName());
		responseDto.setLastName(adminEmployee.getLastName());
		responseDto.setDni(adminEmployee.getDni());
		responseDto.setEmail(adminEmployee.getEmail());
		responseDto.setUpdateDate(adminEmployee.getUpdateDate());
		responseDto.setWorkingHours(adminEmployee.getWorkingHours());
		return responseDto;
	}

	public AdminEmployee update(AdminEmployee adminEmployee, AdminEmployeeRequestDto requestDto) {
		adminEmployee.setFirstName(requestDto.getFirstName());
		adminEmployee.setLastName(requestDto.getLastName());
		adminEmployee.setDni(requestDto.getDni());
		adminEmployee.setEmail(requestDto.getEmail());
		adminEmployee.setWorkingHours(requestDto.getWorkingHours());
		return adminEmployee;
	}
}
