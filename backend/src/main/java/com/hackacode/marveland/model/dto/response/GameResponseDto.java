package com.hackacode.marveland.model.dto.response;

import com.hackacode.marveland.model.entity.OpenHours;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameResponseDto {
    private Long id;
    private String name;
    private Integer capacity;
    private Double price;
    private List<OpenHours> openHours;
}
