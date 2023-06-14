package com.hackacode.marveland.model.dto.request;

import java.util.List;

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
public class PurchaseDetailsRequestDto {

    private String details;

    private PaymentMethod paymentMethod;

    private Long customerId;

    private Long gameEmployeeId;

    private List<TicketRequestDto> tickets;
}
