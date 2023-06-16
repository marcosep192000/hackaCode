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
                .employees(game.getEmployees())
                .tickets(game.getTickets())
                .build();
    }

    public Game fromDtoToEntity(GameRequestDto gameRequestDto, OpenHours openHours) {
        return Game.builder()
                .name(gameRequestDto.getName())
                .openHours(openHours)
                .capacity(gameRequestDto.getCapacity())
                .price(gameRequestDto.getPrice())
                .build();
    }

    public Game updateGame(Game game, GameRequestDto gameRequestDto, OpenHours openHours) {
        game.setName(gameRequestDto.getName());
        game.setOpenHours(openHours);
        game.setCapacity(gameRequestDto.getCapacity());
        game.setPrice(gameRequestDto.getPrice());
        return game;
    }
}