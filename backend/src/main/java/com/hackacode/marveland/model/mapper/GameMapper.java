package com.hackacode.marveland.model.mapper;

import com.hackacode.marveland.model.dto.request.GameRequestDto;
import com.hackacode.marveland.model.dto.response.GameResponseDto;
import com.hackacode.marveland.model.entity.Game;
import org.springframework.stereotype.Component;

@Component
public class GameMapper {

    public GameResponseDto fromEntityToDto(Game game) {
        return GameResponseDto.builder()
                .id(game.getId())
                .description(game.getDescription())
                .openHours(game.getOpenHours())
                .build();
    }

    public Game fromDtoToEntity(GameRequestDto gameRequestDto){
        return Game.builder()
                .description(gameRequestDto.getDescription())
                .openHours(gameRequestDto.getOpenHours())
                .build();
    }

    public Game updateGame(Game game, GameRequestDto gameRequestDto){
        game.setDescription(gameRequestDto.getDescription());
        game.setOpenHours(gameRequestDto.getOpenHours());
        return game;
    }
}
