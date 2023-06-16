package com.hackacode.marveland.service;

import java.util.List;

import com.hackacode.marveland.model.dto.request.GameRequestDto;
import com.hackacode.marveland.model.dto.response.GameResponseDto;

public interface IGameService {

    public void create(GameRequestDto gameRequestDto);

    public GameResponseDto update(Long id, GameRequestDto gameRequestDto);

    public List<GameResponseDto> getAll();

    public GameResponseDto getById(Long id);

    public void delete(Long id);
}
