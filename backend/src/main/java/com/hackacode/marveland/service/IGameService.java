package com.hackacode.marveland.service;

import java.util.List;

import com.hackacode.marveland.model.dto.request.GameRequestDto;
import com.hackacode.marveland.model.dto.response.GameListResponseDto;

public interface IGameService {

    public List<GameListResponseDto> getGamesByFilters();

    public GameListResponseDto getMostPopularGame();

    public GameListResponseDto getGameById(Long id);

    public GameListResponseDto createGame(GameRequestDto request);

    public void assignEmployeeToGame(Long id, Long gameEmployeeId);

    public GameListResponseDto updateGame(GameRequestDto request, Long id);

    public void deleteGame(Long id);
}
