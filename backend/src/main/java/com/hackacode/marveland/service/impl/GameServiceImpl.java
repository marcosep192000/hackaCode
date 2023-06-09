package com.hackacode.marveland.service.impl;

import com.hackacode.marveland.model.dto.request.GameRequestDto;
import com.hackacode.marveland.model.dto.response.GameResponseDto;
import com.hackacode.marveland.model.entity.Game;
import com.hackacode.marveland.model.mapper.GameMapper;
import com.hackacode.marveland.repository.IGameRepository;
import com.hackacode.marveland.service.IGameService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements IGameService {

    private final GameMapper gameMapper;

    private final IGameRepository gameRepository;
    @Transactional
    public void createGame(GameRequestDto gameRequestDto) {
        Game game = gameMapper.fromDtoToEntity(gameRequestDto);
        gameRepository.save(game);
    }

    @Transactional
    public GameResponseDto updateGame(Long id, GameRequestDto gameRequestDto) {
        Game game = gameRepository.findById(id).orElseThrow();
        Game updateGame = gameMapper.updateGame(game, gameRequestDto);
        gameRepository.save(updateGame);
        GameResponseDto response = gameMapper.fromEntityToDto(updateGame);
        return response;
    }

    @Override
    public List<GameResponseDto> getAllGames() {
        List<Game> games = gameRepository.findAll();
        List<GameResponseDto> gameResponseDtoList = new ArrayList<>();
        games.forEach(game -> {
            GameResponseDto response = gameMapper.fromEntityToDto(game);
            gameResponseDtoList.add(response);
        });
        return gameResponseDtoList;
    }

    @Override
    public GameResponseDto getGameById(Long id) {
        Optional<Game> game = gameRepository.findById(id);
        GameResponseDto response = gameMapper.fromEntityToDto(game.get());
        return response;
    }

    @Transactional
    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }
}
