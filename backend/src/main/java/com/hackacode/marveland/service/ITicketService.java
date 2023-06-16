package com.hackacode.marveland.service;

import java.time.LocalDate;
import java.util.List;

import com.hackacode.marveland.model.dto.request.TicketRequestDto;
import com.hackacode.marveland.model.dto.response.TicketResponseDto;
import com.hackacode.marveland.model.entity.Ticket;

public interface ITicketService {

    public List<TicketResponseDto> getByFilters();

    public TicketResponseDto getById(Long id);

    public Integer salesByGameAndDate(Long gameId, LocalDate date);

    public Integer salesByDate(LocalDate date);

    public Ticket create(TicketRequestDto request);

    public TicketResponseDto update(TicketRequestDto request, Long id);

    public void delete(Long id);
}
