package com.hackacode.marveland.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackacode.marveland.model.dto.request.GameRequestDto;
import com.hackacode.marveland.model.dto.response.GameResponseDto;
import com.hackacode.marveland.service.IGameService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/games")
@RequiredArgsConstructor
public class GameController {

    private final IGameService gameService;

    // Juego con la mayor cantidad de entradas vendidas

    @PostMapping("/create")
    public GameRequestDto createGame(@RequestBody GameRequestDto game) {
        gameService.createGame(game);
        return game;
    }

    @PostMapping("/assign")
    public ResponseEntity<GameResponseDto> assignEmployeeToGame(@RequestBody Long gameEmployeeId, Long gameId) {
        GameResponseDto response = gameService.assignEmployeeToGame(gameEmployeeId, gameId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/update")
    public ResponseEntity<GameResponseDto> updateGame(@RequestParam Long id, @RequestBody GameRequestDto game) {
        GameResponseDto response = gameService.updateGame(id, game);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GameResponseDto>> getAllGames() {
        List<GameResponseDto> response = gameService.getAllGames();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/popular")
    public ResponseEntity<GameResponseDto> getMostPopularGame() {
        GameResponseDto response = gameService.getMostPopularGame();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameResponseDto> getGameById(@PathVariable Long id) {
        GameResponseDto response = gameService.getGameById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Long id) {
        gameService.deleteGame(id);
    }
}
