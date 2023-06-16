package com.hackacode.marveland.service;

import java.time.LocalDate;
import java.util.List;

import com.hackacode.marveland.model.dto.request.PurchaseDetailsRequestDto;
import com.hackacode.marveland.model.dto.response.PurchaseDetailsResponseDto;
import com.hackacode.marveland.model.entity.PurchaseDetails;

public interface IPurchaseDetailsService {

    public List<PurchaseDetailsResponseDto> getByFilters();

    public List<PurchaseDetails> findByPurchaseDate(LocalDate date);

    public Double totalSalesByDate(LocalDate date);

    public Double totalSalesByMonth(Integer month);

    public Double totalSalesByYear(Integer year);

    public PurchaseDetailsResponseDto getById(Long id);

    public PurchaseDetailsResponseDto create(PurchaseDetailsRequestDto request);

    public PurchaseDetailsResponseDto update(PurchaseDetailsRequestDto request, Long id);

    public void delete(Long id);
}
