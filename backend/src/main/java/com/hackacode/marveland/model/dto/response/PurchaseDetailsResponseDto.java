package com.hackacode.marveland.model.dto.response;

import java.time.LocalDate;
import java.util.List;

import com.hackacode.marveland.util.enums.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseDetailsResponseDto {

    private Long id;


    private String details;

    private LocalDate purchaseDate;

    private PaymentMethod paymentMethod;

    private Double finalPrice;

    private List<TicketResponseDto> tickets;

    private CustomerResponseDto customer;

    private EmployeeResponseDto gameEmployee;
}
