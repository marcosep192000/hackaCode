package com.hackacode.marveland.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hackacode.marveland.model.dto.request.GameRequestDto;
import com.hackacode.marveland.model.dto.response.GameDetailsResponseDto;
import com.hackacode.marveland.model.entity.Game;
import com.hackacode.marveland.model.entity.OpenHours;
import com.hackacode.marveland.model.mapper.GameMapper;
import com.hackacode.marveland.repository.IGameRepository;
import com.hackacode.marveland.repository.IOpenHoursRepository;
import com.hackacode.marveland.service.IGameService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements IGameService {

    private final GameMapper gameMapper;

    private final IGameRepository gameRepository;

    private final IOpenHoursRepository openHoursRepository;

    @Override
    public List<GameDetailsResponseDto> getGamesByFilters() {
        return gameRepository.findAll().stream()
                .map(game -> gameMapper.fromEntityToDto(game))
                .collect(Collectors.toList());
    }

    @Override
    public GameDetailsResponseDto getGameById(Long id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found"));
        return gameMapper.fromEntityToDto(game);
    }

    @Override
    @Transactional
    public GameDetailsResponseDto createGame(GameRequestDto request) {
        OpenHours openHours = openHoursRepository.findById(request.getOpenHoursId())
                .orElseThrow(() -> new RuntimeException("Open Hours not found"));
        Game Game = gameMapper.fromDtoToEntity(request, openHours);
        gameRepository.save(Game);
        return gameMapper.fromEntityToDto(Game);
    }

    @Override
    @Transactional
    public GameDetailsResponseDto updateGame(GameRequestDto request, Long id) {
        OpenHours openHours = openHoursRepository.findById(request.getOpenHoursId())
                .orElseThrow(() -> new RuntimeException("Open Hours not found"));
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found"));
        Game updatedGame = gameMapper.update(game, openHours, request);
        gameRepository.save(updatedGame);
        return gameMapper.fromEntityToDto(updatedGame);
    }

    @Override
    public void deleteGame(Long id) {
        if (!gameRepository.existsById(id)) {
            throw new RuntimeException("Game not found");
        }
        gameRepository.deleteById(id);
    }
}