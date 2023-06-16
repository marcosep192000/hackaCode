package com.hackacode.marveland.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import com.hackacode.marveland.model.entity.PurchaseDetails;
import com.hackacode.marveland.repository.IPurchaseDetailsRepository;
import com.hackacode.marveland.service.IPurchaseDetailsService;
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


    @Override //lista de tickets de un juego vendidos en un dia
    public List<Ticket> soldByGameAndDate(Long gameId, LocalDate date){
        List<Ticket> tickets = ticketRepository.findAll();
        List<Ticket> ticketList = null;
        for (Ticket ticket : tickets){
            if(ticket.getGame().getId() == gameId && ticket.getPurchaseDetails().getPurchaseDate() == date){
                ticketList.add(ticket);
            }
        }
        return ticketList;
    }

    @Override
    public List<Ticket> soldByDate(LocalDate date) {
        List<PurchaseDetails> purchases = purchaseRepository.findByPurchaseDate(date);
        List<Ticket> tickets = new ArrayList<>();
        for (PurchaseDetails purchase : purchases){
            tickets.addAll(purchase.getTickets());
        }
        return tickets;
    }
}
