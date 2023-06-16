package com.hackacode.marveland.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackacode.marveland.model.dto.request.TicketRequestDto;
import com.hackacode.marveland.model.dto.response.TicketResponseDto;
import com.hackacode.marveland.model.entity.Ticket;
import com.hackacode.marveland.service.ITicketService;
import com.hackacode.marveland.util.exceptions.GeneralMessage;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final ITicketService ticketService;

    @GetMapping("/all")
    public ResponseEntity<List<TicketResponseDto>> getAll() {
        List<TicketResponseDto> response = ticketService.getAll();
        return ResponseEntity.ok().body(response);

    @GetMapping("/filters")
    public ResponseEntity<List<TicketResponseDto>> getByFilters() {
        List<TicketResponseDto> response = ticketService.getTicketsByFilters();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/ticketsSoldByGameAndGame")
    public List<Ticket> salesByGameAndDate(@RequestParam Long gameId, @RequestParam LocalDate date) {
        return ticketService.soldByGameAndDate(gameId, date);
    }

    @GetMapping("/ticketSoldByDate")
    public List<Ticket> salesByDate(@RequestParam LocalDate date) {
        return ticketService.soldByDate(date);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketResponseDto> getById(@PathVariable Long id) {
        TicketResponseDto response = ticketService.getTicketById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/ticketsSoldByGameAndGame")
    public Integer salesByGameAndDate(@RequestParam Long gameId, @RequestParam LocalDate date){
        return ticketService.salesByGameAndDate(gameId, date);
    }

    @GetMapping("/ticketSoldByDate")
    public Integer salesByDate(@RequestParam LocalDate date){
        return ticketService.salesByDate(date);

    @PutMapping("/update/{id}")
    public ResponseEntity<TicketResponseDto> update(@PathVariable Long id,
            @RequestBody TicketRequestDto request) {
        TicketResponseDto response = ticketService.updateTicket(request, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GeneralMessage> delete(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new GeneralMessage("Ticket successfully deleted"));
    }
}
