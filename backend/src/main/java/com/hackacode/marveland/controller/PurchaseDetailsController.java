package com.hackacode.marveland.controller;

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

    @PostMapping("/create")
    public ResponseEntity<PurchaseDetailsResponseDto> createPurchaseDetails(
            @RequestBody PurchaseDetailsRequestDto purchaseDetails) {
        PurchaseDetailsResponseDto response = purchaseDetailsService.createPurchaseDetails(purchaseDetails);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PurchaseDetailsResponseDto>> getAllPurchases() {
        List<PurchaseDetailsResponseDto> response = purchaseDetailsService.getAllPurchases();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseDetailsResponseDto> getPurchaseById(@RequestParam Long id) {
        PurchaseDetailsResponseDto response = purchaseDetailsService.getPurchaseById(id);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public void deletePurchase(@RequestParam Long id) {
        purchaseDetailsService.deletePurchase(id);
    }
}
