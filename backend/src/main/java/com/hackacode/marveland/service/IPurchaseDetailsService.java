package com.hackacode.marveland.service;

import com.hackacode.marveland.model.dto.request.PurchaseDetailsRequestDto;
import com.hackacode.marveland.model.dto.response.PurchaseDetailsResponseDto;

import java.util.List;

public interface IPurchaseDetailsService {
    public void createPurchaseDetails(PurchaseDetailsRequestDto purchaseDetailsRequestDto);

    public List<PurchaseDetailsResponseDto> getAllPurchases();

    public PurchaseDetailsResponseDto getPurchaseById(Long id);

    public void deletePurchase(Long id);
}
