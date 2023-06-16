package com.hackacode.marveland.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Open Hours Id cannot be null")
    private Long openHoursId;

    @NotNull(message = "Capacity cannot be null")
    private Integer capacity;

    @NotNull(message = "Price cannot be null")
    private Double price;
}
