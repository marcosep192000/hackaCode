package com.hackacode.marveland.service;

import java.util.List;

import com.hackacode.marveland.model.dto.request.PurchaseDetailsRequestDto;
import com.hackacode.marveland.model.dto.response.PurchaseDetailsResponseDto;

public interface IPurchaseDetailsService {

    public PurchaseDetailsResponseDto createPurchaseDetails(PurchaseDetailsRequestDto purchaseDetailsRequestDto);

    public List<PurchaseDetailsResponseDto> getAllPurchases();

    public PurchaseDetailsResponseDto getPurchaseById(Long id);

    public void deletePurchase(Long id);
}
