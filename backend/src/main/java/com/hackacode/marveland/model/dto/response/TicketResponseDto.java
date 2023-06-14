package com.hackacode.marveland.model.dto.response;

import java.util.Date;

import com.hackacode.marveland.model.entity.Game;

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
public class TicketResponseDto {

    private Long id;

    private String fullName;

    private Integer dni;

    private Date expirationDate;

    private Game game;
}
