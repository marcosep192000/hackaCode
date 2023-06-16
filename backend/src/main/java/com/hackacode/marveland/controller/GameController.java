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
@RequestMapping("/api/v1/games")
@RequiredArgsConstructor
public class GameController {

    private final IGameService gameService;

    // Juego con la mayor cantidad de entradas vendidas
    
    @PostMapping("/create")
    public GameRequestDto create(@RequestBody GameRequestDto game){
        gameService.create(game);
        return game;
    }

    @PostMapping("/update")
    public ResponseEntity<GameResponseDto> update(@RequestParam Long id, @RequestBody GameRequestDto game){
        GameResponseDto response = gameService.update(id, game);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GameResponseDto>> getAll(){
        List<GameResponseDto> response = gameService.getAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameResponseDto> getById(@PathVariable Long id){
        GameResponseDto response = gameService.getById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){gameService.delete(id);
    }
}
