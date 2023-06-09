package com.hackacode.marveland.service.impl;

import com.hackacode.marveland.model.dto.request.TicketRequestDto;
import com.hackacode.marveland.model.dto.response.TicketResponseDto;
import com.hackacode.marveland.model.entity.Ticket;
import com.hackacode.marveland.model.mapper.TicketMapper;
import com.hackacode.marveland.repository.ITicketRepository;
import com.hackacode.marveland.service.ITicketService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements ITicketService {

    private final TicketMapper ticketMapper;
    private final ITicketRepository ticketRepository;
    @Transactional
    public void createTicket(TicketRequestDto ticketRequestDto) {
        Ticket ticket = ticketMapper.fromDtoToEntity(ticketRequestDto);
        ticketRepository.save(ticket);
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
