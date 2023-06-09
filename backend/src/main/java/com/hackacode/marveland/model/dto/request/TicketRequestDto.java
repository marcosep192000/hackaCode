package com.hackacode.marveland.model.dto.request;

import com.hackacode.marveland.model.entity.Game;
import com.hackacode.marveland.model.entity.PurchaseDetails;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequestDto implements Serializable {

    private Date expirationDate;

    private Game game;

    private PurchaseDetails purchaseDetails;
}