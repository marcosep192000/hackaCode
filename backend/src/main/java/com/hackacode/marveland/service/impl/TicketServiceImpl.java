package com.hackacode.marveland.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hackacode.marveland.model.dto.request.TicketRequestDto;
import com.hackacode.marveland.model.dto.response.TicketResponseDto;
import com.hackacode.marveland.model.entity.Game;
import com.hackacode.marveland.model.entity.Ticket;
import com.hackacode.marveland.model.mapper.TicketMapper;
import com.hackacode.marveland.repository.IGameRepository;
import com.hackacode.marveland.repository.ITicketRepository;
import com.hackacode.marveland.service.ITicketService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements ITicketService {

    private final TicketMapper ticketMapper;

    private final ITicketRepository ticketRepository;

    private final IGameRepository gameRepository;

    @Transactional
    public Ticket createTicket(TicketRequestDto ticketRequestDto) {
        Game game = gameRepository.findById(ticketRequestDto.getGameId()).orElseThrow();
        Ticket ticket = ticketMapper.fromDtoToEntity(ticketRequestDto, game);
        return ticketRepository.save(ticket);
    }

    @Override
    public List<TicketResponseDto> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        List<TicketResponseDto> ticketResponseDtoList = new ArrayList<>();
        tickets.forEach(ticket -> {
            TicketResponseDto response = ticketMapper.fromEntityToDto(ticket);
            ticketResponseDtoList.add(response);
        });
        return ticketResponseDtoList;
    }

    @Override
    public TicketResponseDto getTicketById(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        TicketResponseDto response = ticketMapper.fromEntityToDto(ticket.get());
        return response;
    }

    @Transactional
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
