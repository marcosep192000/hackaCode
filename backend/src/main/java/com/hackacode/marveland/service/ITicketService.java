package com.hackacode.marveland.service;

import java.time.LocalDate;
import java.util.List;

import com.hackacode.marveland.model.dto.request.TicketRequestDto;
import com.hackacode.marveland.model.dto.response.TicketResponseDto;
import com.hackacode.marveland.model.entity.Ticket;

public interface ITicketService {

    public Ticket create(TicketRequestDto ticketRequestDto);

    public List<TicketResponseDto> getAll();

    public TicketResponseDto getById(Long id);

    public void delete(Long id);

    public Integer salesByGameAndDate(Long gameId, LocalDate date);

    public Integer salesByDate(LocalDate date);
}
