package com.hackacode.marveland.controller;

import com.hackacode.marveland.model.dto.request.GameRequestDto;
import com.hackacode.marveland.model.dto.response.GameResponseDto;
import com.hackacode.marveland.service.IGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/game")
@RequiredArgsConstructor
public class GameController {

    private final IGameService gameService;

    @PostMapping("/create")
    public GameRequestDto createGame(@RequestBody GameRequestDto game){
        gameService.createGame(game);
        return game;
    }

    @PostMapping("/update")
    public ResponseEntity<GameResponseDto> updateGame(@RequestParam Long id, @RequestBody GameRequestDto game){
        GameResponseDto response = gameService.updateGame(id, game);
        return ResponseEntity.ok().body(response);
    }
    @GetMapping
    public ResponseEntity<List<GameResponseDto>> getAllGames(){
        List<GameResponseDto> response = gameService.getAllGames();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameResponseDto> getGameById(@PathVariable Long id){
        GameResponseDto response = gameService.getGameById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Long id){
        gameService.deleteGame(id);
    }
}
