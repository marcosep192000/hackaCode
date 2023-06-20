package com.hackacode.marveland.service;

import java.time.LocalDate;
import java.util.List;

import com.hackacode.marveland.model.dto.request.PurchaseDetailsRequestDto;
import com.hackacode.marveland.model.dto.response.PurchaseDetailsResponseDto;
import com.hackacode.marveland.model.entity.PurchaseDetails;
import com.hackacode.marveland.model.entity.Ticket;

public interface IPurchaseDetailsService {

    PurchaseDetails findById(Long id);

    public List<PurchaseDetailsResponseDto> getByFilters();

    Double calculateTotalPrice(List<Ticket> tickets);

    public List<PurchaseDetails> findByPurchaseDate(LocalDate date);

    public Double totalSalesByDate(LocalDate date);

    public Double totalSalesByMonth(int month);

    public Double totalSalesByYear(int year);

    public PurchaseDetailsResponseDto getById(Long id);

    public PurchaseDetailsResponseDto create(PurchaseDetailsRequestDto request);

    public PurchaseDetailsResponseDto update(PurchaseDetailsRequestDto request, Long id);

    public void delete(Long id);

}
