package com.hackacode.marveland.service.impl;

import com.hackacode.marveland.model.dto.request.PurchaseDetailsRequestDto;
import com.hackacode.marveland.model.dto.response.GameResponseDto;
import com.hackacode.marveland.model.dto.response.PurchaseDetailsResponseDto;
import com.hackacode.marveland.model.entity.Game;
import com.hackacode.marveland.model.entity.PurchaseDetails;
import com.hackacode.marveland.model.mapper.PurchaseDetailsMapper;
import com.hackacode.marveland.repository.IPurchaseDetailsRepository;
import com.hackacode.marveland.service.IPurchaseDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PurchaseDetailsServiceImpl implements IPurchaseDetailsService {

    private final PurchaseDetailsMapper purchaseDetailsMapper;
    private final IPurchaseDetailsRepository purchaseDetailsRepository;
    @Override
    public void createPurchaseDetails(PurchaseDetailsRequestDto purchaseDetailsRequestDto) {
        PurchaseDetails purchaseDetails = purchaseDetailsMapper.fromDtoToEntity(purchaseDetailsRequestDto);
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
