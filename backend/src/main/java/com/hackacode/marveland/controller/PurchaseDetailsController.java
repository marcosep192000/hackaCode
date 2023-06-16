package com.hackacode.marveland.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

    private final IPurchaseDetailsService PurchaseDetailsService;

    @GetMapping("/filters")
    @PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE')")
    public ResponseEntity<List<PurchaseDetailsResponseDto>> getPurchaseDetailssByFilters() {
        List<PurchaseDetailsResponseDto> response = PurchaseDetailsService.getPurchaseDetailsByFilters();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE')")
    public ResponseEntity<PurchaseDetailsResponseDto> getPurchaseDetailsById(@PathVariable Long id) {
        PurchaseDetailsResponseDto response = PurchaseDetailsService.getPurchaseDetailsById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('EMPLOYEE')")
    public ResponseEntity<PurchaseDetailsResponseDto> createPurchaseDetails(
            @RequestBody PurchaseDetailsRequestDto request) {
        PurchaseDetailsResponseDto response = PurchaseDetailsService.createPurchaseDetails(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/update/{id}")
    @PreAuthorize("hasRole('EMPLOYEE')")
    public ResponseEntity<PurchaseDetailsResponseDto> updatePurchaseDetails(@PathVariable Long id,
            @RequestBody PurchaseDetailsRequestDto request) {
        PurchaseDetailsResponseDto response = PurchaseDetailsService.updatePurchaseDetails(request, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('EMPLOYEE')")
    public ResponseEntity<GeneralMessage> deletePurchaseDetails(@PathVariable Long id) {
        PurchaseDetailsService.deletePurchaseDetails(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new GeneralMessage("PurchaseDetails successfully deleted"));
    }
}
