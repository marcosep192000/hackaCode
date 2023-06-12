package com.hackacode.marveland.controller;

import com.hackacode.marveland.model.dto.request.PurchaseDetailsRequestDto;
import com.hackacode.marveland.model.dto.response.PurchaseDetailsResponseDto;
import com.hackacode.marveland.service.IPurchaseDetailsService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/purchaseDetails")
@RequiredArgsConstructor
public class PurchaseDetailsController {

    private final IPurchaseDetailsService purchaseDetailsService;
    @PostMapping("/create")
    public PurchaseDetailsRequestDto createPurchaseDetails(@RequestBody PurchaseDetailsRequestDto purchaseDetails){
        purchaseDetailsService.createPurchaseDetails(purchaseDetails);
        return purchaseDetails;
    }

    @GetMapping
    public ResponseEntity<List<PurchaseDetailsResponseDto>> getAllPurchases(){
        List<PurchaseDetailsResponseDto> response = purchaseDetailsService.getAllPurchases();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<PurchaseDetailsResponseDto> getPurchaseById(@RequestParam Long id){
        PurchaseDetailsResponseDto response = purchaseDetailsService.getPurchaseById(id);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public void deletePurchase(@RequestParam Long id){
        purchaseDetailsService.deletePurchase(id);
    }
}
