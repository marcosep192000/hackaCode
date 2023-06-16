package com.hackacode.marveland.service;

import java.time.LocalDate;
import java.util.List;

import com.hackacode.marveland.model.dto.request.PurchaseDetailsRequestDto;
import com.hackacode.marveland.model.dto.response.PurchaseDetailsResponseDto;
import com.hackacode.marveland.model.entity.PurchaseDetails;

public interface IPurchaseDetailsService {

    public List<PurchaseDetailsResponseDto> getPurchaseDetailsByFilters();

    public List<PurchaseDetails> findByPurchaseDate(LocalDate date);

    public Double totalSalesByDate(LocalDate date);

    public PurchaseDetailsResponseDto getPurchaseDetailsById(Long id);

    public PurchaseDetailsResponseDto createPurchaseDetails(PurchaseDetailsRequestDto request);

    public PurchaseDetailsResponseDto updatePurchaseDetails(PurchaseDetailsRequestDto request, Long id);

    public void deletePurchaseDetails(Long id);
}
