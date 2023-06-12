package com.hackacode.marveland.model.mapper;

import com.hackacode.marveland.model.dto.request.AdminEmployeeRequestDto;
import com.hackacode.marveland.model.dto.response.AdminEmployeeResponseDto;
import com.hackacode.marveland.model.entity.AdminEmployee;
import com.hackacode.marveland.repository.AdminEmployeeRepository;
import org.springframework.stereotype.Component;

@Component
public class AdminEmployeeMapper {
	private final AdminEmployeeRepository adminEmployeeRepository;

	public AdminEmployeeMapper(AdminEmployeeRepository adminEmployeeRepository) {
		this.adminEmployeeRepository = adminEmployeeRepository;
	}

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
