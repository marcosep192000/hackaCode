package com.hackacode.marveland.model.mapper;

import org.springframework.stereotype.Component;

import com.hackacode.marveland.model.dto.request.TicketRequestDto;
import com.hackacode.marveland.model.dto.response.TicketResponseDto;
import com.hackacode.marveland.model.entity.Game;
import com.hackacode.marveland.model.entity.Ticket;

@Component
public class TicketMapper {

    public TicketResponseDto fromEntityToDto(Ticket ticket) {
        return TicketResponseDto.builder()
                .id(ticket.getId())
                .fullName(ticket.getFullName())
                .dni(ticket.getDni())
                .expirationDate(ticket.getExpirationDate())
                .game(ticket.getGame())
                .build();
    }

    public Ticket fromDtoToEntity(TicketRequestDto ticketRequestDto, Game game) {
        return Ticket.builder()
                .fullName(ticketRequestDto.getFullName())
                .expirationDate(ticketRequestDto.getExpirationDate())
                .dni(ticketRequestDto.getDni())
                .game(game)
                .build();
    }
}
