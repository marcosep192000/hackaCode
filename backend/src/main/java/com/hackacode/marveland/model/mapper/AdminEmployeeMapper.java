package com.hackacode.marveland.model.mapper;

import org.springframework.stereotype.Component;

import com.hackacode.marveland.model.dto.request.AdminEmployeeRequestDto;
import com.hackacode.marveland.model.dto.response.AdminEmployeeResponseDto;
import com.hackacode.marveland.model.entity.AdminEmployee;

@Component
public class AdminEmployeeMapper {

	public AdminEmployeeResponseDto fromEntityToDto(AdminEmployee adminEmployee){
        AdminEmployeeResponseDto responseDto = new AdminEmployeeResponseDto();
		responseDto.setId(adminEmployee.getId());
		responseDto.setFirstName(adminEmployee.getFirstName());
		responseDto.setLastName(adminEmployee.getLastName());
		return responseDto;
	}
	public AdminEmployee update(AdminEmployee adminEmployee, AdminEmployeeRequestDto requestDto){
		adminEmployee.setDni(requestDto.getDni());
		adminEmployee.setEmail(requestDto.getEmail());
		adminEmployee.setFirstName(requestDto.getFirstName());
		adminEmployee.setLastName(requestDto.getLastName());
		return adminEmployee;
	}
}
