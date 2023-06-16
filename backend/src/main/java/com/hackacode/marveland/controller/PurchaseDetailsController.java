package com.hackacode.marveland.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackacode.marveland.model.dto.request.PurchaseDetailsRequestDto;
import com.hackacode.marveland.model.dto.response.PurchaseDetailsResponseDto;
import com.hackacode.marveland.service.IPurchaseDetailsService;
import com.hackacode.marveland.util.exceptions.GeneralMessage;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/purchases")
@RequiredArgsConstructor
public class PurchaseDetailsController {

    private final IPurchaseDetailsService purchaseDetailsService;

    @GetMapping("/filters")
    public ResponseEntity<List<PurchaseDetailsResponseDto>> getPurchaseDetailsByFilters() {
        List<PurchaseDetailsResponseDto> response = purchaseDetailsService.getPurchaseDetailsByFilters();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseDetailsResponseDto> getPurchaseDetailsById(@PathVariable Long id) {
        PurchaseDetailsResponseDto response = purchaseDetailsService.getPurchaseDetailsById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<PurchaseDetailsResponseDto> createPurchaseDetails(
            @RequestBody PurchaseDetailsRequestDto request) {
        PurchaseDetailsResponseDto response = purchaseDetailsService.createPurchaseDetails(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PurchaseDetailsResponseDto> updatePurchaseDetails(@PathVariable Long id,
            @RequestBody PurchaseDetailsRequestDto request) {
        PurchaseDetailsResponseDto response = purchaseDetailsService.updatePurchaseDetails(request, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GeneralMessage> deletePurchaseDetails(@PathVariable Long id) {
        purchaseDetailsService.deletePurchaseDetails(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new GeneralMessage("Purchase successfully deleted"));
    }
}
