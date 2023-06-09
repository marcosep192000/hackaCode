package com.hackacode.marveland.model.dto.request;

import lombok.*;
import org.springframework.security.core.parameters.P;

import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDetailsRequestDto implements Serializable {

    private String details;

    private Date date;
}
