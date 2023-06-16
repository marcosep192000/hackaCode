package com.hackacode.marveland.model.mapper;

import java.time.LocalDate;

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
                .build();
    }

    public Ticket fromDtoToEntity(TicketRequestDto ticketRequestDto, Game game) {
        return Ticket.builder()
                .fullName(ticketRequestDto.getFullName())
                .expirationDate(LocalDate.now().plusMonths(3))
                .dni(ticketRequestDto.getDni())
                .game(game)
                .build();
    }
}
