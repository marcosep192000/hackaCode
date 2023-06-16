package com.hackacode.marveland.service;

import java.util.List;

import com.hackacode.marveland.model.dto.request.GameRequestDto;
import com.hackacode.marveland.model.dto.response.GameResponseDto;

public interface IGameService {

    public void createGame(GameRequestDto gameRequestDto);

    public GameResponseDto updateGame(Long id, GameRequestDto gameRequestDto);

    public List<GameResponseDto> getAllGames();

    public GameResponseDto getGameById(Long id);

    public void deleteGame(Long id);
}
