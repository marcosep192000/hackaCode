package com.hackacode.marveland.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.hackacode.marveland.model.entity.PurchaseDetails;
import com.hackacode.marveland.repository.IPurchaseDetailsRepository;
import com.hackacode.marveland.service.IPurchaseDetailsService;
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

    private final IPurchaseDetailsRepository purchaseRepository;

    @Transactional
    public Ticket create(TicketRequestDto ticketRequestDto) {
        Game game = gameRepository.findById(ticketRequestDto.getGameId()).orElseThrow();
        Ticket ticket = ticketMapper.fromDtoToEntity(ticketRequestDto, game);
        return ticketRepository.save(ticket);
    }

    @Override
    public List<TicketResponseDto> getAll() {
        List<Ticket> tickets = ticketRepository.findAll();
        List<TicketResponseDto> ticketResponseDtoList = new ArrayList<>();
        tickets.forEach(ticket -> {
            TicketResponseDto response = ticketMapper.fromEntityToDto(ticket);
            ticketResponseDtoList.add(response);
        });
        return ticketResponseDtoList;
    }

    @Override
    public TicketResponseDto getById(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        TicketResponseDto response = ticketMapper.fromEntityToDto(ticket.get());
        return response;
    }

    @Transactional
    public void delete(Long id) {
        ticketRepository.deleteById(id);
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
