package com.hackacode.marveland.model.dto.response;

import java.time.LocalDate;
import java.util.List;

import com.hackacode.marveland.model.entity.Customer;
import com.hackacode.marveland.model.entity.GameEmployee;
import com.hackacode.marveland.model.entity.Ticket;
import com.hackacode.marveland.util.enums.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDetailsResponseDto {

    private Long id;


    private String details;

    private LocalDate purchaseDate;

    private Double finalPrice;

    private List<Ticket> tickets;

    private PaymentMethod paymentMethod;

    private Customer customer;

    private GameEmployee gameEmployee;
}
