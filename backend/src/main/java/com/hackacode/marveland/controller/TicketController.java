package com.hackacode.marveland.controller;

import com.hackacode.marveland.model.dto.request.TicketRequestDto;
import com.hackacode.marveland.model.dto.response.TicketResponseDto;
import com.hackacode.marveland.service.ITicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final ITicketService ticketService;

    @PostMapping("/create")
    public TicketRequestDto createTicket(@RequestBody TicketRequestDto ticket) {
        ticketService.createTicket(ticket);
        return ticket;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TicketResponseDto>> getAllTickets() {
        List<TicketResponseDto> response = ticketService.getAllTickets();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketResponseDto> getTicketById(@RequestParam Long id) {
        TicketResponseDto response = ticketService.getTicketById(id);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public void deleteTicket(@RequestParam Long id) {
        ticketService.deleteTicket(id);
    }

    @GetMapping("/ticketsSoldByGame")
    public List<Ticket> ticketsSoldByGame(@RequestParam Long gameId, @RequestParam Date date){
        return ticketService.ticketsSoldByGame(gameId, date);
    }

    //@GetMapping("/ticketsSoldByDate")
    //public Integer ticketsSoldByDate(@RequestParam Date date){
    //    return ticketService.ticketsSoldByDay(date);
    //}
}
