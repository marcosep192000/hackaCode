package com.hackacode.marveland.service;

import java.util.List;

import com.hackacode.marveland.model.dto.request.GameRequestDto;
import com.hackacode.marveland.model.dto.response.GameResponseDto;

public interface IGameService {

    public List<GameResponseDto> getAll();

    public List<GameResponseDto> getByFilters();

    public GameResponseDto getMostPopularGame();

    public GameResponseDto getById(Long id);

    public GameResponseDto create(GameRequestDto request);

    public void assignEmployeeToGame(Long id, Long gameEmployeeId);

    public GameResponseDto update(GameRequestDto request, Long id);

    public void delete(Long id);
}
