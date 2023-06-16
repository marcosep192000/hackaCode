package com.hackacode.marveland.service;

import java.util.List;

import com.hackacode.marveland.model.dto.request.GameRequestDto;
import com.hackacode.marveland.model.dto.response.GameDetailsResponseDto;

public interface IGameService {

    public List<GameDetailsResponseDto> getGamesByFilters();

    public GameDetailsResponseDto getGameById(Long id);

    public GameDetailsResponseDto createGame(GameRequestDto request);

    public GameDetailsResponseDto updateGame(GameRequestDto request, Long id);

    public void deleteGame(Long id);
}
