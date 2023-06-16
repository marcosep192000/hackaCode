package com.hackacode.marveland.model.dto.request;

import java.util.List;

import com.hackacode.marveland.util.enums.PaymentMethod;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class PurchaseDetailsRequestDto {

    @NotBlank(message = "Details cannot be blank")
    private String details;

    @NotBlank(message = "Payment method cannot be blank")
    private PaymentMethod paymentMethod;

    @NotNull(message = "Customer Id cannot be null")
    private Long customerId;

    @NotNull(message = "Game Employee Id cannot be null")
    private Long gameEmployeeId;

    @NotEmpty(message = "Ticket list cannot be empty")
    private List<TicketRequestDto> tickets;
}
