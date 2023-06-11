package com.hackacode.marveland.service.impl;

import com.hackacode.marveland.model.dto.request.GameEmployeeRequestDto;
import com.hackacode.marveland.model.dto.response.GameEmployeeResponseDto;
import com.hackacode.marveland.model.entity.GameEmployee;
import com.hackacode.marveland.service.IGameEmployeeService;

import java.util.List;

public class GameEmployeeServiceImpl implements IGameEmployeeService {
	@Override
	public void create(GameEmployeeRequestDto requestDto) {
	}

	@Override
	public void Update(GameEmployeeRequestDto requestDto, GameEmployee request) {
	}

	@Override
	public List<GameEmployeeResponseDto> getAll() {
		return null;
	}

	@Override
	public GameEmployeeResponseDto getById(Long id) {
		return null;
	}

	@Override
	public void delete(Long id) {
	}
}
