package com.hackacode.marveland.model.dto.response;

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
public class OpenHoursResponseDto {

    private Long id;

    private Date startTime;

    private Date endTime;
}
