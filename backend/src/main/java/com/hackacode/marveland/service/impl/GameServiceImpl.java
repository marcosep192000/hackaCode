package com.hackacode.marveland.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hackacode.marveland.model.dto.request.GameRequestDto;
import com.hackacode.marveland.model.dto.response.GameListResponseDto;
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

    private final IOpenHoursRepository openHoursRepository;

    private final IGameEmployeeRepository gameEmployeeRepository;

    private Game findById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found"));
    }

    @Override
    public List<GameListResponseDto> getByFilters() {
        return gameRepository.findAll().stream()
                .map(game -> gameMapper.fromEntityToDto(game))
                .collect(Collectors.toList());
    }

    @Override
    public GameListResponseDto getMostPopularGame() {
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
    public GameListResponseDto getById(Long id) {
        Game game = findById(id);
        return gameMapper.fromEntityToDto(game);
    }

    @Transactional
    public GameListResponseDto create(GameRequestDto request) {
        Optional<OpenHours> openHours = openHoursRepository.findById(request.getOpenHoursId());
        Game Game = gameMapper.fromDtoToEntity(request, openHours.get());
        gameRepository.save(Game);
        return gameMapper.fromEntityToDto(Game);
    }

    @Override
    public void assignEmployeeToGame(Long id, Long gameEmployeeId) {
        GameEmployee gameEmployee = gameEmployeeRepository.findById(gameEmployeeId)
                .orElseThrow(() -> new RuntimeException("Game Employee not found"));
        Game game = findById(id);
        gameEmployee.setGame(game);
        game.getEmployees().add(gameEmployee);

        gameEmployeeRepository.save(gameEmployee);
        gameRepository.save(game);
    }

    @Override
    @Transactional
    public GameListResponseDto update(GameRequestDto request, Long id) {
        Optional<OpenHours> openHours = openHoursRepository.findById(request.getOpenHoursId());
        Game game = findById(id);
        Game updatedGame = gameMapper.update(game, openHours.get(), request);
        gameRepository.save(updatedGame);
        return gameMapper.fromEntityToDto(updatedGame);
    }

    @Override
    public void delete(Long id) {
        gameRepository.delete(findById(id));
    }
}