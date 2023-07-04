package com.hackacode.marveland.controller;

import java.util.List;

import com.hackacode.marveland.config.jwt.JwtProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackacode.marveland.model.dto.request.GameRequestDto;
import com.hackacode.marveland.model.dto.response.GameResponseDto;
import com.hackacode.marveland.service.IGameService;
import com.hackacode.marveland.util.exceptions.GeneralMessage;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/games")
@CrossOrigin(origins = "*")
@Tag(name = "Games", description = "Management of games in Marveland. It allows creating, modifying, and deleting games, as well as obtaining detailed information about them.")
@SecurityRequirement(name = "bearerAuth")
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