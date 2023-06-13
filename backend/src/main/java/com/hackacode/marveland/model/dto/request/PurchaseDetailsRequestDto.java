package com.hackacode.marveland.model.dto.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
public class PurchaseDetailsRequestDto implements Serializable {

    private String details;

    private Date date;

    private PaymentMethod paymentMethod;

    private Long customerId;

    private Long gameEmployeeId;

    private List<Ticket> tickets;
}
