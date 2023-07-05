package com.hackacode.marveland.model.dto.request;

import com.hackacode.marveland.model.entity.OpenHours;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class GameRequestDto {

    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotNull(message = "Capacity cannot be null")
    private Integer capacity;
    @NotNull(message = "Price cannot be null")
    private Double price;
    @NotNull(message = "start Time cannot be null")
    private LocalTime startTime;
    @NotNull(message = "end time cannot be null")
    private LocalTime endTime;
}
