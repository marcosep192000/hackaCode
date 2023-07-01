package com.hackacode.marveland.model.mapper;

import org.springframework.stereotype.Component;

import com.hackacode.marveland.model.dto.request.GameRequestDto;
import com.hackacode.marveland.model.dto.response.GameResponseDto;
import com.hackacode.marveland.model.entity.Game;
import com.hackacode.marveland.model.entity.OpenHours;

@Component
public class GameMapper {

    public GameResponseDto fromEntityToDto(Game game) {
        return GameResponseDto.builder()
                .id(game.getId())
                .name(game.getName())
                .openHours(game.getOpenHours())
                .capacity(game.getCapacity())
                .price(game.getPrice())
                .build();
    }
    public Game fromDtoToEntity(GameRequestDto request) {
        return Game.builder()
                .name(request.getName())
                .openHours(request.getOpenHours())
                .capacity(request.getCapacity())
                .price(request.getPrice())
                .build();
    }

    public Game update(Game game, OpenHours openHours, GameRequestDto request) {
        game.setName(request.getName());
 //        game.setOpenHours(openHours);
        game.setCapacity(request.getCapacity());
        game.setPrice(request.getPrice());
        return game;
    }
}