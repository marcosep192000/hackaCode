package com.hackacode.marveland.model.dto.request;

import java.io.Serializable;
import java.util.Date;

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
public class TicketRequestDto implements Serializable {

    private String fullName;

    private Integer dni;

    private Date expirationDate;

    private Long gameId;
}
