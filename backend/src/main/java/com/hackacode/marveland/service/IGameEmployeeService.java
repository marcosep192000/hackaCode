package com.hackacode.marveland.service;

import java.util.List;

import com.hackacode.marveland.model.dto.request.GameEmployeeRequestDto;
import com.hackacode.marveland.model.dto.response.GameEmployeeResponseDto;
import com.hackacode.marveland.model.entity.GameEmployee;

public interface IGameEmployeeService {

	public void create(GameEmployeeRequestDto requestDto);

	public void update(GameEmployeeRequestDto requestDto, GameEmployee request);

	public List<GameEmployeeResponseDto> getAll();

	public GameEmployeeResponseDto getById(Long id);

	public void delete(Long id);
}
