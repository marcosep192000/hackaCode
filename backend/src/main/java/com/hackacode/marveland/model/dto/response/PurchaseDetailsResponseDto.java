package com.hackacode.marveland.model.dto.response;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDetailsResponseDto implements Serializable {

    private Long id;


    private String details;

    private Date date;
}
