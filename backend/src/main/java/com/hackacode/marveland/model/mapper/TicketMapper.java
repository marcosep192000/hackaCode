package com.hackacode.marveland.model.mapper;

import com.hackacode.marveland.model.dto.request.TicketRequestDto;
import com.hackacode.marveland.model.dto.response.TicketResponseDto;
import com.hackacode.marveland.model.entity.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    public TicketResponseDto fromEntityToDto(Ticket ticket){
        return TicketResponseDto.builder()
                .id(ticket.getId())
                .expirationDate(ticket.getExpirationDate())
                .game(ticket.getGame())
                .purchaseDetails(ticket.getPurchaseDetails())
                .dni(ticket.getDni())
                .name(ticket.getName())
                .build();
    }

    public Ticket fromDtoToEntity(TicketRequestDto ticketRequestDto){
        return Ticket.builder()
                .expirationDate(ticketRequestDto.getExpirationDate())
                .game(ticketRequestDto.getGame())
                .purchaseDetails(ticketRequestDto.getPurchaseDetails())
                .dni(ticketRequestDto.getDni())
                .name(ticketRequestDto.getName())
                .build();
    }
}
