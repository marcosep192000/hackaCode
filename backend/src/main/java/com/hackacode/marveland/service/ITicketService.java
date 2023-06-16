package com.hackacode.marveland.service;

import java.util.List;

import com.hackacode.marveland.model.dto.request.TicketRequestDto;
import com.hackacode.marveland.model.dto.response.TicketResponseDto;
import com.hackacode.marveland.model.entity.Ticket;

public interface ITicketService {

    public List<TicketResponseDto> getTicketsByFilters();

    public TicketResponseDto getTicketById(Long id);

    public Ticket createTicket(TicketRequestDto request);

    public TicketResponseDto updateTicket(TicketRequestDto request, Long id);

    public void deleteTicket(Long id);
}
