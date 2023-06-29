package com.hackacode.marveland.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    private final IOpenHoursRepository openHoursRepository;
    private final IGameEmployeeRepository gameEmployeeRepository;

    @Override
    public List<GameResponseDto> getAll(){
        return gameRepository.findAll().stream()
                .map(game -> gameMapper.fromEntityToDto(game))
                .collect(Collectors.toList());
    }

    @Override
    public GameResponseDto getById(Long id) {
        Game game = gameRepository.findById(id).get();
        return gameMapper.fromEntityToDto(game);
    }

    @Override
    public List<GameResponseDto> getByFilters() {
        return gameRepository.findAll().stream()
                .map(game -> gameMapper.fromEntityToDto(game))
                .collect(Collectors.toList());
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

    @Transactional
    public GameResponseDto create(GameRequestDto request) {
        List<OpenHours> openHours = request.getOpenHours();
        System.out.println(openHours);
        request.setOpenHours(null);
        Game game = gameMapper.fromDtoToEntity(request);
        gameRepository.save(game);
        for (OpenHours detail : openHours) {
            detail.setGame(game);
            System.out.println(detail);
        }
        openHoursRepository.saveAll(openHours);
        request.setOpenHours(openHours);
        return gameMapper.fromEntityToDto(game);
    }

    @Override
    public void assignEmployeeToGame(Long id, Long gameEmployeeId) {
        GameEmployee gameEmployee = gameEmployeeRepository.findById(gameEmployeeId)
                .orElseThrow(() -> new RuntimeException("Game Employee not found"));
        Game game = gameRepository.findById(id).get();
        gameEmployee.setGame(game);
        game.getEmployees().add(gameEmployee);

        gameEmployeeRepository.save(gameEmployee);
        gameRepository.save(game);
    }

    @Override
    @Transactional
    public GameResponseDto update(GameRequestDto request, Long id) {
        Optional<OpenHours> openHours = openHoursRepository.findById(request.getOpenHoursId());
        Game game = gameRepository.findById(id).get();
        Game updatedGame = gameMapper.update(game, openHours.get(), request);
        gameRepository.save(updatedGame);
        return gameMapper.fromEntityToDto(updatedGame);
    }

    @Override
    public void delete(Long id) {
        gameRepository.deleteById(id);
    }
}