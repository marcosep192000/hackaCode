package com.hackacode.marveland.model.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hackacode.marveland.model.dto.request.PurchaseDetailsRequestDto;
import com.hackacode.marveland.model.dto.response.PurchaseDetailsResponseDto;
import com.hackacode.marveland.model.entity.Customer;
import com.hackacode.marveland.model.entity.GameEmployee;
import com.hackacode.marveland.model.entity.PurchaseDetails;
import com.hackacode.marveland.model.entity.Ticket;

@Component
public class PurchaseDetailsMapper {

    public PurchaseDetailsResponseDto fromEntityToDto(PurchaseDetails purchaseDetails) {
        return PurchaseDetailsResponseDto.builder()
                .id(purchaseDetails.getId())
                .details(purchaseDetails.getDetails())
                .date(purchaseDetails.getDate())
                .build();
    }

    public PurchaseDetails fromDtoToEntity(PurchaseDetailsRequestDto purchaseDetailsRequestDto, Customer customer,
            GameEmployee gameEmployee, List<Ticket> tickets) {
        return PurchaseDetails.builder()
                .details(purchaseDetailsRequestDto.getDetails())
                .date(purchaseDetailsRequestDto.getDate())
                .paymentMethod(purchaseDetailsRequestDto.getPaymentMethod())
                .customer(customer)
                .gameEmployee(gameEmployee)
                .tickets(tickets)
                .build();
    }
}
