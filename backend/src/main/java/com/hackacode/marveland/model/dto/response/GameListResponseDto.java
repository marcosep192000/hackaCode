package com.hackacode.marveland.model.dto.response;

import com.hackacode.marveland.model.entity.OpenHours;

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
public class GameListResponseDto {

    private Long id;

    private String name;

    private OpenHours openHours;

    private Integer capacity;

    private Double price;
}
