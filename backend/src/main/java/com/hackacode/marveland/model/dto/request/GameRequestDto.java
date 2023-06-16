package com.hackacode.marveland.model.dto.request;

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
public class GameRequestDto {

    private String name;

    private Long openHoursId;

    private Integer capacity;

    private Double price;
}
