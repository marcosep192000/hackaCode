package com.hackacode.marveland.controller;

import com.hackacode.marveland.model.dto.response.OpenHoursResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hackacode.marveland.model.dto.request.GameRequestDto;
import com.hackacode.marveland.model.dto.response.GameResponseDto;
import com.hackacode.marveland.service.IGameService;
import com.hackacode.marveland.util.exceptions.GeneralMessage;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/v1/games")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class GameController {

    private final IGameService gameService;

    @GetMapping("/getMostPopularGame")
    public ResponseEntity<GameResponseDto> getMostPopularGame() {
        GameResponseDto response = gameService.getMostPopularGame();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GameResponseDto>> getAll() {
        List<GameResponseDto> response = gameService.getAll();
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<GameResponseDto> getById(@PathVariable Long id) {
        GameResponseDto response = gameService.getById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<GameResponseDto> create(@RequestBody GameRequestDto request) {
        GameResponseDto response = gameService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<GameResponseDto> update(@PathVariable Long id,
            @RequestBody GameRequestDto request) {
        GameResponseDto response = gameService.update(request, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GeneralMessage> delete(@PathVariable Long id) {
        gameService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new GeneralMessage("Game successfully deleted"));
    }
}