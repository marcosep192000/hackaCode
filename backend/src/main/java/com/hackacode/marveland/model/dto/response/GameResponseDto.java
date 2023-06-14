package com.hackacode.marveland.model.dto.response;

import java.util.List;

import com.hackacode.marveland.model.entity.GameEmployee;
import com.hackacode.marveland.model.entity.OpenHours;
import com.hackacode.marveland.model.entity.Ticket;

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
public class GameResponseDto {

    private Long id;

    private String name;

    private OpenHours openHours;

    private Integer capacity;

    private Double price;

    private GameEmployee gameEmployee;

    private List<Ticket> tickets;
}
