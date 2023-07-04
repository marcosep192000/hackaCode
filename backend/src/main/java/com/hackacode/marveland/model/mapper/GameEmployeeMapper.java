package com.hackacode.marveland.model.mapper;
import com.hackacode.marveland.model.dto.request.CustomerRequestDto;
import com.hackacode.marveland.model.dto.request.GameEmployeeRequestDto;
import com.hackacode.marveland.model.dto.response.GameEmployeeResponseDto;
import com.hackacode.marveland.model.entity.AdminEmployee;
import com.hackacode.marveland.model.entity.Customer;
import com.hackacode.marveland.model.entity.GameEmployee;
import com.hackacode.marveland.model.entity.User;
import org.springframework.stereotype.Component;
@Component
public class GameEmployeeMapper {

	public GameEmployee dtoToEntity(GameEmployeeRequestDto requestDto, AdminEmployee adminEmployee){
		GameEmployee gameEmployee = new GameEmployee();
		gameEmployee.setAdminEmployee(adminEmployee);
	    gameEmployee.setDni(requestDto.getDni());
		gameEmployee.setEmail(requestDto.getEmail());
		gameEmployee.setFirstName(requestDto.getFirstName());
		gameEmployee.setLastName(requestDto.getLastName());
		gameEmployee.setWorkingHours(requestDto.getWorkingHours());
		gameEmployee.setUser(User.builder().build());
		return gameEmployee;
	}
	public GameEmployeeResponseDto entityToDto(GameEmployee gameEmployee){
		GameEmployeeResponseDto  response = new GameEmployeeResponseDto();
		gameEmployee.setDni(gameEmployee.getDni());
		gameEmployee.setEmail(gameEmployee.getEmail());
		gameEmployee.setFirstName(gameEmployee.getFirstName());
		gameEmployee.setLastName(gameEmployee.getLastName());
		gameEmployee.setWorkingHours(gameEmployee.getWorkingHours());
		gameEmployee.setGame(gameEmployee.getGame());
		gameEmployee.setUser(User.builder().build());
		return response;
	}
}
