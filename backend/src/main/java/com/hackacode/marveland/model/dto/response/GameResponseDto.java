package com.hackacode.marveland.model.dto.response;

import com.hackacode.marveland.model.entity.OpenHours;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
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
    private LocalTime startTime;
    private LocalTime endTime;
    private long games;
}
