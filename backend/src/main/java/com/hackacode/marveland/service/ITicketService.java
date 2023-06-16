package com.hackacode.marveland.service;

import java.util.List;

import com.hackacode.marveland.model.dto.request.TicketRequestDto;
import com.hackacode.marveland.model.dto.response.TicketResponseDto;

public interface ITicketService {

    public List<TicketResponseDto> getTicketsByFilters();

    public TicketResponseDto getTicketById(Long id);

    public TicketResponseDto createTicket(TicketRequestDto request);

    public TicketResponseDto updateTicket(TicketRequestDto request, Long id);

    public void deleteTicket(Long id);
}
