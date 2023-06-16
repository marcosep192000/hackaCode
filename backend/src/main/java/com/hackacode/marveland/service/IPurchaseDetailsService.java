package com.hackacode.marveland.service;

import java.time.LocalDate;
import java.util.List;

import com.hackacode.marveland.model.dto.request.PurchaseDetailsRequestDto;
import com.hackacode.marveland.model.dto.response.PurchaseDetailsResponseDto;
import com.hackacode.marveland.model.entity.PurchaseDetails;

public interface IPurchaseDetailsService {

    public PurchaseDetailsResponseDto create(PurchaseDetailsRequestDto purchaseDetailsRequestDto);

    public List<PurchaseDetailsResponseDto> getAll();

    public PurchaseDetailsResponseDto getById(Long id);

    public void delete(Long id);

    public List<PurchaseDetails> findByPurchaseDate(LocalDate date);

    Double totalSalesByDate(LocalDate date);
}
