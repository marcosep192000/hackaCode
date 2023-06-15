package com.hackacode.marveland.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hackacode.marveland.model.dto.request.GameRequestDto;
import com.hackacode.marveland.model.dto.response.GameResponseDto;
import com.hackacode.marveland.model.entity.Game;
import com.hackacode.marveland.model.entity.GameEmployee;
import com.hackacode.marveland.model.entity.OpenHours;
import com.hackacode.marveland.model.mapper.GameMapper;
import com.hackacode.marveland.repository.IGameEmployeeRepository;
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

    private final IGameEmployeeRepository gameEmployeeRepository;

    private final IOpenHoursRepository openHoursRepository;

    @Transactional
    public void createGame(GameRequestDto gameRequestDto) {
        OpenHours openHours = openHoursRepository.findById(gameRequestDto.getOpenHoursId()).orElseThrow();
        Game game = gameMapper.fromDtoToEntity(gameRequestDto, openHours);
        gameRepository.save(game);
    }

    @Override
    public GameResponseDto assignEmployeeToGame(Long gameEmployeeId, Long gameId) {
        GameEmployee gameEmployee = gameEmployeeRepository.findById(gameEmployeeId).orElseThrow();
        Game game = gameRepository.findById(gameId).orElseThrow();

        gameEmployee.setGame(game);
        game.getEmployees().add(gameEmployee);

        gameEmployeeRepository.save(gameEmployee);
        gameRepository.save(game);

        return gameMapper.fromEntityToDto(game);
    }

    @Transactional
    public GameResponseDto updateGame(Long id, GameRequestDto gameRequestDto) {
        Game game = gameRepository.findById(id).orElseThrow();
        OpenHours openHours = openHoursRepository.findById(gameRequestDto.getOpenHoursId()).orElseThrow();
        Game updateGame = gameMapper.updateGame(game, gameRequestDto, openHours);
        gameRepository.save(updateGame);
        GameResponseDto response = gameMapper.fromEntityToDto(updateGame);
        return response;
    }

    @Override
    public GameResponseDto getMostPopularGame() {
        List<Game> games = gameRepository.findAll();

        Game mostPopularGame = null;
        int maxTicketsSold = 0;

        for (Game game : games) {
            int totalTickets = game.getTickets().size();
            if (totalTickets > maxTicketsSold) {
                maxTicketsSold = totalTickets;
                mostPopularGame = game;
            }
        }

        return gameMapper.fromEntityToDto(mostPopularGame);
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
