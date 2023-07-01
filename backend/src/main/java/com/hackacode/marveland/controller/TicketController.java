package com.hackacode.marveland.controller;

import java.time.LocalDate;
import java.util.List;

import com.hackacode.marveland.model.dto.request.TicketRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hackacode.marveland.model.dto.response.TicketResponseDto;
import com.hackacode.marveland.model.entity.Ticket;
import com.hackacode.marveland.service.ITicketService;
import com.hackacode.marveland.util.exceptions.GeneralMessage;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/tickets")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TicketController {

    private final ITicketService ticketService;

    @GetMapping("/all")
    public ResponseEntity<List<TicketResponseDto>> getAll() {
        List<TicketResponseDto> response = ticketService.getAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/ticketsSoldByGameAndDate")
    public Integer salesByGameAndDate(@RequestParam Long gameId, @RequestParam LocalDate date) {
        return ticketService.salesByGameAndDate(gameId, date);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getById(@PathVariable Long id) {
        Ticket response = ticketService.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/ticketSoldByDate")
    public Integer salesByDate(@RequestParam LocalDate date) {
        return ticketService.salesByDate(date);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TicketResponseDto> update(@PathVariable Long id, @RequestBody TicketRequestDto request) {
        TicketResponseDto response = ticketService.update(request, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GeneralMessage> delete(@PathVariable Long id) {
        ticketService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new GeneralMessage("Ticket successfully deleted"));
    }
}
