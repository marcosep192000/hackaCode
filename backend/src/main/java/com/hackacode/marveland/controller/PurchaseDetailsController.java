package com.hackacode.marveland.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackacode.marveland.model.dto.request.PurchaseDetailsRequestDto;
import com.hackacode.marveland.model.dto.response.PurchaseDetailsResponseDto;
import com.hackacode.marveland.service.IPurchaseDetailsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/purchases")
@RequiredArgsConstructor
public class PurchaseDetailsController {

    private final IPurchaseDetailsService purchaseDetailsService;

    // Sumatoria total de los montos de ventas en un determinado día.
    // Sumatoria total de los montos de ventas en un determinado mes y año.

    @PostMapping("/create")
    public ResponseEntity<PurchaseDetailsResponseDto> create(
            @RequestBody PurchaseDetailsRequestDto purchaseDetails) {
        PurchaseDetailsResponseDto response = purchaseDetailsService.create(purchaseDetails);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PurchaseDetailsResponseDto>> getAll() {
        List<PurchaseDetailsResponseDto> response = purchaseDetailsService.getAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseDetailsResponseDto> getById(@RequestParam Long id) {
        PurchaseDetailsResponseDto response = purchaseDetailsService.getById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/totalSalesByDate")
    public Double totalSalesByDate(@RequestParam LocalDate date){
        return purchaseDetailsService.totalSalesByDate(date);
    }

    @GetMapping("/totalSalesByMonth")
    public Double totalSalesByMonth(@RequestParam int month){
        return purchaseDetailsService.totalSalesByMonth(month);
    }

    @GetMapping("/totalSalesByYear")
    public Double totalSalesByYear(@RequestParam int year){
        return purchaseDetailsService.totalSalesByYear(year);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestParam Long id) {
        purchaseDetailsService.delete(id);
    }
}
