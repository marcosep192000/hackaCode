package com.hackacode.marveland.model.mapper;

import java.time.LocalDate;
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

    public PurchaseDetailsResponseDto fromEntityToDto(PurchaseDetails purchaseDetails, Double finalPrice) {
        return PurchaseDetailsResponseDto.builder()
                .id(purchaseDetails.getId())
                .details(purchaseDetails.getDetails())
                .purchaseDate(purchaseDetails.getPurchaseDate())
                .finalPrice(finalPrice)
                .tickets(purchaseDetails.getTickets())
                .paymentMethod(purchaseDetails.getPaymentMethod())
                .customer(purchaseDetails.getCustomer())
                .gameEmployee(purchaseDetails.getGameEmployee())
                .build();
    }

    public PurchaseDetails fromDtoToEntity(PurchaseDetailsRequestDto purchaseDetailsRequestDto, Customer customer,
            GameEmployee gameEmployee, List<Ticket> tickets) {
        return PurchaseDetails.builder()
                .details(purchaseDetailsRequestDto.getDetails())
                .purchaseDate(LocalDate.now())
                .tickets(tickets)
                .paymentMethod(purchaseDetailsRequestDto.getPaymentMethod())
                .customer(customer)
                .gameEmployee(gameEmployee)
                .build();
    }
}
