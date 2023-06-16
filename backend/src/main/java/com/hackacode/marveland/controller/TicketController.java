package com.hackacode.marveland.controller;

import com.hackacode.marveland.model.dto.request.TicketRequestDto;
import com.hackacode.marveland.model.dto.response.TicketResponseDto;
import com.hackacode.marveland.model.entity.Ticket;
import com.hackacode.marveland.service.ITicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final ITicketService ticketService;

    @GetMapping("/all")
    public ResponseEntity<List<TicketResponseDto>> getAll() {
        List<TicketResponseDto> response = ticketService.getAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketResponseDto> getById(@RequestParam Long id) {
        TicketResponseDto response = ticketService.getById(id);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestParam Long id) {
        ticketService.delete(id);
    }

    @GetMapping("/ticketsSoldByGameAndGame")
    public Integer soldByGameAndDate(@RequestParam Long gameId, @RequestParam LocalDate date){
        return ticketService.salesByGameAndDate(gameId, date);
    }

    @GetMapping("/ticketSoldByDate")
    public Integer soldByDate(@RequestParam LocalDate date){
        return ticketService.salesByDate(date);
    }
}
