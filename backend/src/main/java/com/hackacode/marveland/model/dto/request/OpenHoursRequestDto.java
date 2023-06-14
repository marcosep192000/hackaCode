package com.hackacode.marveland.model.dto.request;

import java.time.LocalTime;

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
public class OpenHoursRequestDto {

    private LocalTime startTime;

    private LocalTime endTime;
}
