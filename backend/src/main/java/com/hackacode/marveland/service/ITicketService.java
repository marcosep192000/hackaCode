package com.hackacode.marveland.service;

import com.hackacode.marveland.model.dto.request.TicketRequestDto;
import com.hackacode.marveland.model.dto.response.TicketResponseDto;

import java.util.List;

public interface ITicketService {

    public void createTicket (TicketRequestDto ticketRequestDto);

    public List<TicketResponseDto> getAllTickets();

    public TicketResponseDto getTicketById(Long id);

    public void deleteTicket(Long id);
}
