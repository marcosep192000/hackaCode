package com.hackacode.marveland.service;

import java.util.List;

import com.hackacode.marveland.model.dto.request.GameRequestDto;
import com.hackacode.marveland.model.dto.response.GameListResponseDto;

public interface IGameService {

    public List<GameListResponseDto> getByFilters();

    public GameListResponseDto getMostPopularGame();

    public GameListResponseDto getById(Long id);

    public GameListResponseDto create(GameRequestDto request);

    public void assignEmployeeToGame(Long id, Long gameEmployeeId);

    public GameListResponseDto update(GameRequestDto request, Long id);

    public void delete(Long id);
}
