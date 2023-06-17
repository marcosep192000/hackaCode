package com.hackacode.marveland.model.mapper;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.hackacode.marveland.model.dto.request.TicketRequestDto;
import com.hackacode.marveland.model.dto.response.TicketResponseDto;
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

    public Ticket fromDtoToEntity(TicketRequestDto request) {
        return Ticket.builder()
                .fullName(request.getFullName())
                .dni(request.getDni())
                .expirationDate(LocalDate.now().plusMonths(3))
                .build();
    }

    public Ticket update(Ticket ticket, TicketRequestDto request) {
        return null;
    }
}
