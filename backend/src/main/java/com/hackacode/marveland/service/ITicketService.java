package com.hackacode.marveland.service;

import java.util.List;

import com.hackacode.marveland.model.dto.request.TicketRequestDto;
import com.hackacode.marveland.model.dto.response.TicketResponseDto;
import com.hackacode.marveland.model.entity.Ticket;
import com.hackacode.marveland.model.entity.Ticket;

import java.util.Date;
import java.util.List;

public interface ITicketService {

    public Ticket createTicket(TicketRequestDto ticketRequestDto);

    public List<TicketResponseDto> getAllTickets();

    public TicketResponseDto getTicketById(Long id);

    public void deleteTicket(Long id);

    public List<Ticket> ticketsSoldByGame(Long gameId, Date date);

    //public List<Ticket> ticketsSoldByDay(Date date);
}
