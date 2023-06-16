package com.hackacode.marveland.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackacode.marveland.model.dto.request.GameRequestDto;
import com.hackacode.marveland.model.dto.response.GameDetailsResponseDto;
import com.hackacode.marveland.service.IGameService;
import com.hackacode.marveland.util.exceptions.GeneralMessage;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/games")
@RequiredArgsConstructor
public class GameController {

    private final IGameService gameService;

    @GetMapping("/filters")
    public ResponseEntity<List<GameDetailsResponseDto>> getGamesByFilters() {
        List<GameDetailsResponseDto> response = gameService.getGamesByFilters();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDetailsResponseDto> getGameById(@PathVariable Long id) {
        GameDetailsResponseDto response = gameService.getGameById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<GameDetailsResponseDto> createGame(@RequestBody GameRequestDto request) {
        GameDetailsResponseDto response = gameService.createGame(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<GameDetailsResponseDto> updateGame(@PathVariable Long id,
            @RequestBody GameRequestDto request) {
        GameDetailsResponseDto response = gameService.updateGame(request, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GeneralMessage> deleteGame(@PathVariable Long id) {
        gameService.deleteGame(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new GeneralMessage("Game successfully deleted"));
    }
}