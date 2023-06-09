package com.hackacode.marveland.model.mapper;

import com.hackacode.marveland.model.dto.request.PurchaseDetailsRequestDto;
import com.hackacode.marveland.model.dto.response.PurchaseDetailsResponseDto;
import com.hackacode.marveland.model.entity.PurchaseDetails;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
public class PurchaseDetailsMapper {

    public PurchaseDetailsResponseDto fromEntityToDto(PurchaseDetails purchaseDetails){
        return PurchaseDetailsResponseDto.builder()
                .id(purchaseDetails.getId())
                .details(purchaseDetails.getDetails())
                .date(purchaseDetails.getDate())
                .build();
    }

    public PurchaseDetails fromDtoToEntity(PurchaseDetailsRequestDto purchaseDetailsRequestDto){
        return PurchaseDetails.builder()
                .details(purchaseDetailsRequestDto.getDetails())
                .date(purchaseDetailsRequestDto.getDate())
                .build();
    }
}
