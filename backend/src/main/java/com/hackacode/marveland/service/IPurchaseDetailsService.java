package com.hackacode.marveland.service;

import java.util.List;

import com.hackacode.marveland.model.dto.request.PurchaseDetailsRequestDto;
import com.hackacode.marveland.model.dto.response.PurchaseDetailsResponseDto;

public interface IPurchaseDetailsService {

    public List<PurchaseDetailsResponseDto> getPurchaseDetailsByFilters();

    public PurchaseDetailsResponseDto getPurchaseDetailsById(Long id);

    public PurchaseDetailsResponseDto createPurchaseDetails(PurchaseDetailsRequestDto request);

    public PurchaseDetailsResponseDto updatePurchaseDetails(PurchaseDetailsRequestDto request, Long id);

    public void deletePurchaseDetails(Long id);
}