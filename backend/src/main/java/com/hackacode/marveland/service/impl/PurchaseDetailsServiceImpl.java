package com.hackacode.marveland.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hackacode.marveland.model.dto.request.PurchaseDetailsRequestDto;
import com.hackacode.marveland.model.dto.response.PurchaseDetailsResponseDto;
import com.hackacode.marveland.model.entity.Customer;
import com.hackacode.marveland.model.entity.GameEmployee;
import com.hackacode.marveland.model.entity.PurchaseDetails;
import com.hackacode.marveland.model.mapper.PurchaseDetailsMapper;
import com.hackacode.marveland.repository.CustomerRepository;
import com.hackacode.marveland.repository.GameEmployeeRepository;
import com.hackacode.marveland.repository.IPurchaseDetailsRepository;
import com.hackacode.marveland.service.IPurchaseDetailsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PurchaseDetailsServiceImpl implements IPurchaseDetailsService {

    private final PurchaseDetailsMapper purchaseDetailsMapper;
    private final IPurchaseDetailsRepository purchaseDetailsRepository;
    private final CustomerRepository customerRepository;
    private final GameEmployeeRepository gameEmployeeRepository;

    @Override
    public void createPurchaseDetails(PurchaseDetailsRequestDto purchaseDetailsRequestDto) {
    
        Customer customer = customerRepository.findById(purchaseDetailsRequestDto.getCustomerId()).orElseThrow();
        GameEmployee gameEmployee = gameEmployeeRepository.findById(purchaseDetailsRequestDto.getGameEmployeeId()).orElseThrow();
        PurchaseDetails purchaseDetails = purchaseDetailsMapper.fromDtoToEntity(purchaseDetailsRequestDto, customer, gameEmployee);
        purchaseDetailsRepository.save(purchaseDetails);
    }

    @Override
    public List<PurchaseDetailsResponseDto> getAllPurchases() {
        List<PurchaseDetails> purchases = purchaseDetailsRepository.findAll();
        List<PurchaseDetailsResponseDto> purchaseResponseDtoList = new ArrayList<>();
        purchases.forEach(purchase -> {
            PurchaseDetailsResponseDto response = purchaseDetailsMapper.fromEntityToDto(purchase);
            purchaseResponseDtoList.add(response);
        });
        return purchaseResponseDtoList;
    }

    @Override
    public PurchaseDetailsResponseDto getPurchaseById(Long id) {
        Optional<PurchaseDetails> purchase = purchaseDetailsRepository.findById(id);
        PurchaseDetailsResponseDto response = purchaseDetailsMapper.fromEntityToDto(purchase.get());
        return response;
    }

    @Override
    public void deletePurchase(Long id) {
        purchaseDetailsRepository.deleteById(id);
    }
}
