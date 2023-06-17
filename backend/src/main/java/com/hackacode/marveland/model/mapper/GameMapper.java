package com.hackacode.marveland.model.mapper;

import org.springframework.stereotype.Component;

import com.hackacode.marveland.model.dto.request.GameRequestDto;
import com.hackacode.marveland.model.dto.response.GameListResponseDto;
import com.hackacode.marveland.model.entity.Game;
import com.hackacode.marveland.model.entity.OpenHours;

@Component
public class GameMapper {

    public GameListResponseDto fromEntityToDto(Game game) {
        return GameListResponseDto.builder()
                .id(game.getId())
                .name(game.getName())
                .openHours(game.getOpenHours())
                .capacity(game.getCapacity())
                .price(game.getPrice())
                .build();
    }

    public Game fromDtoToEntity(GameRequestDto request, OpenHours openHours) {
        return Game.builder()
                .name(request.getName())
                .openHours(openHours)
                .capacity(request.getCapacity())
                .price(request.getPrice())
                .build();
    }

    public Game update(Game game, OpenHours openHours, GameRequestDto request) {
        game.setName(request.getName());
        game.setOpenHours(openHours);
        game.setCapacity(request.getCapacity());
        game.setPrice(request.getPrice());
        return game;
    }
}