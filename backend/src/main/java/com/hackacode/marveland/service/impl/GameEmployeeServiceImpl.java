package com.hackacode.marveland.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hackacode.marveland.model.dto.request.GameEmployeeRequestDto;
import com.hackacode.marveland.model.dto.response.GameEmployeeResponseDto;
import com.hackacode.marveland.model.entity.GameEmployee;
import com.hackacode.marveland.repository.IGameEmployeeRepository;
import com.hackacode.marveland.service.IGameEmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameEmployeeServiceImpl implements IGameEmployeeService {

	private final IGameEmployeeRepository gameEmployeeRepository;
	
	@Override
	public void create(GameEmployeeRequestDto requestDto) {
	}

	@Override
	public void update(GameEmployeeRequestDto requestDto, GameEmployee request) {
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
