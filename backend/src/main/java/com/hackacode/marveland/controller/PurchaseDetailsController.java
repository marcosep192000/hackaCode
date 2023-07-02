package com.hackacode.marveland.controller;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hackacode.marveland.model.dto.request.PurchaseDetailsRequestDto;
import com.hackacode.marveland.model.dto.response.PurchaseDetailsResponseDto;
import com.hackacode.marveland.service.IPurchaseDetailsService;
import com.hackacode.marveland.util.exceptions.GeneralMessage;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/purchases")
@CrossOrigin(origins = "*")
@Tag(name = "Purchases", description = "Management of purchases in Marveland. It allows creating, modifying, and deleting purchases, as well as obtaining detailed information about them.")
@SecurityRequirement(name = "bearerAuth")
@RequiredArgsConstructor
public class PurchaseDetailsController {

    private final IPurchaseDetailsService purchaseDetailsService;

    @GetMapping("/totalSalesByDate")
    public Double totalSalesByDate(@RequestParam LocalDate date) {
        return purchaseDetailsService.totalSalesByDate(date);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseDetailsResponseDto> getById(@PathVariable Long id) {
        PurchaseDetailsResponseDto response = purchaseDetailsService.getById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<PurchaseDetailsResponseDto> create(
            @RequestBody PurchaseDetailsRequestDto request) {
        PurchaseDetailsResponseDto response = purchaseDetailsService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PurchaseDetailsResponseDto> update(@PathVariable Long id,
            @RequestBody PurchaseDetailsRequestDto request) {
        PurchaseDetailsResponseDto response = purchaseDetailsService.update(request, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @GetMapping("/totalSalesByMonth")
    public Double totalSalesByMonth(@RequestParam int month, @RequestParam int year) {
        return purchaseDetailsService.totalSalesByMonth(month, year);
    }

    @GetMapping("/totalSalesByYear")
    public Double totalSalesByYear(@RequestParam int year) {
        return purchaseDetailsService.totalSalesByYear(year);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GeneralMessage> delete(@PathVariable Long id) {
        purchaseDetailsService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new GeneralMessage("Purchase successfully deleted"));
    }
}
