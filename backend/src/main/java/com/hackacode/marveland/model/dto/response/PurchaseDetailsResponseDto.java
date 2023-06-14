package com.hackacode.marveland.model.dto.response;

import java.util.Date;
import java.util.List;

import com.hackacode.marveland.model.entity.GameEmployee;
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

    private Date date;

    private List<TicketResponseDto> tickets;

    private PaymentMethod paymentMethod;

    private CustomerResponseDto customer;

    private GameEmployee gameEmployee;
}
