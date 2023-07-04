package com.hackacode.marveland.service;

import com.hackacode.marveland.model.dto.request.CustomerRequestDto;
import com.hackacode.marveland.model.dto.request.GameEmployeeRequestDto;
import com.hackacode.marveland.model.dto.response.GameEmployeeResponseDto;
import com.hackacode.marveland.model.entity.GameEmployee;

import java.util.List;

public interface IGameEmployeeService {

	public List<GameEmployee> All();
	public List<GameEmployeeResponseDto> getAll();
	public GameEmployeeResponseDto create(GameEmployeeRequestDto request, String email);
	public void update(CustomerRequestDto request, Long id);
	public void delete(Long id);
}
