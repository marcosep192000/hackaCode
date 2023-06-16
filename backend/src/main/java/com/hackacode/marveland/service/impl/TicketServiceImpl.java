package com.hackacode.marveland.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hackacode.marveland.model.dto.request.TicketRequestDto;
import com.hackacode.marveland.model.dto.response.TicketResponseDto;
import com.hackacode.marveland.model.entity.Ticket;
import com.hackacode.marveland.model.mapper.TicketMapper;
import com.hackacode.marveland.repository.ITicketRepository;
import com.hackacode.marveland.service.ITicketService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements ITicketService {

    private final TicketMapper ticketMapper;

    private final ITicketRepository ticketRepository;

    private Ticket findTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

    @Override
    public List<TicketResponseDto> getTicketsByFilters() {
        return ticketRepository.findAll().stream()
                .map(ticket -> ticketMapper.fromEntityToDto(ticket))
                .collect(Collectors.toList());
    }

    @Override
    public TicketResponseDto getTicketById(Long id) {
        Ticket ticket = findTicketById(id);
        return ticketMapper.fromEntityToDto(ticket);
    }

    @Override
    @Transactional
    public Ticket createTicket(TicketRequestDto request) {
        Ticket ticket = ticketMapper.fromDtoToEntity(request);
        return ticketRepository.save(ticket);
    }

    @Override
    @Transactional
    public TicketResponseDto updateTicket(TicketRequestDto request, Long id) {
        Ticket ticket = findTicketById(id);
        Ticket updatedTicket = ticketMapper.updateTicket(ticket, request);
        ticketRepository.save(updatedTicket);
        return ticketMapper.fromEntityToDto(updatedTicket);
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.delete(findTicketById(id));
    }
}
