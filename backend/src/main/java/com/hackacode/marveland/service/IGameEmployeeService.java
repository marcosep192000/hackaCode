package com.hackacode.marveland.service;

import com.hackacode.marveland.model.dto.request.CustomerRequestDto;
import com.hackacode.marveland.model.dto.request.GameEmployeeRequestDto;
import com.hackacode.marveland.model.dto.response.CustomerResponseDto;
import com.hackacode.marveland.model.dto.response.GameEmployeeResponseDto;
import com.hackacode.marveland.model.entity.Customer;
import com.hackacode.marveland.model.entity.GameEmployee;

import java.util.List;

public interface IGameEmployeeService {
	void create(GameEmployeeRequestDto requestDto);
	void Update(GameEmployeeRequestDto requestDto, GameEmployee request);

	public List<GameEmployeeResponseDto> getAll();

	public GameEmployeeResponseDto getById(Long id);

	public void delete(Long id);
}
