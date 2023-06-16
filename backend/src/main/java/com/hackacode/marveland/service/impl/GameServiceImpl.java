package com.hackacode.marveland.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.hackacode.marveland.model.mapper.GameMapper;
import org.springframework.stereotype.Service;

import com.hackacode.marveland.model.dto.request.GameRequestDto;
import com.hackacode.marveland.model.dto.response.GameResponseDto;
import com.hackacode.marveland.model.entity.Game;
import com.hackacode.marveland.model.entity.OpenHours;
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

    @Transactional
    public void create(GameRequestDto gameRequestDto) {
        OpenHours openHours = openHoursRepository.findById(gameRequestDto.getOpenHoursId()).orElseThrow();
        Game game = gameMapper.fromDtoToEntity(gameRequestDto, openHours);
        gameRepository.save(game);
    }

    @Transactional
    public GameResponseDto update(Long id, GameRequestDto gameRequestDto) {
        Game game = gameRepository.findById(id).orElseThrow();
        OpenHours openHours = openHoursRepository.findById(gameRequestDto.getOpenHoursId()).orElseThrow();
        Game updateGame = gameMapper.updateGame(game, gameRequestDto, openHours);
        gameRepository.save(updateGame);
        GameResponseDto response = gameMapper.fromEntityToDto(updateGame);
        return response;
    }

    @Override
    public List<GameResponseDto> getAll() {
        List<Game> games = gameRepository.findAll();
        List<GameResponseDto> gameResponseDtoList = new ArrayList<>();
        games.forEach(game -> {
            GameResponseDto response = gameMapper.fromEntityToDto(game);
            gameResponseDtoList.add(response);
        });
        return gameResponseDtoList;
    }

    @Override
    public GameResponseDto getById(Long id) {
        Optional<Game> game = gameRepository.findById(id);
        GameResponseDto response = gameMapper.fromEntityToDto(game.get());
        return response;
    }

    @Transactional
    public void delete(Long id) {
        gameRepository.deleteById(id);
    }
}
