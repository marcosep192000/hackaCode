package com.hackacode.marveland.model.mapper;

import org.springframework.stereotype.Component;

import com.hackacode.marveland.model.dto.request.OpenHoursRequestDto;
import com.hackacode.marveland.model.dto.response.OpenHoursResponseDto;
import com.hackacode.marveland.model.entity.OpenHours;

@Component
public class OpenHoursMapper {

    public OpenHoursResponseDto fromEntityToDto(OpenHours openHours) {
        return OpenHoursResponseDto.builder()
                .id(openHours.getId())
                .startTime(openHours.getStartTime())
                .endTime(openHours.getEndTime())
                .build();
    }

    public OpenHours fromDtoToEntity(OpenHoursRequestDto request) {
        return OpenHours.builder()
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .build();
    }

    public OpenHours updateOpenHours(OpenHours openHours, OpenHoursRequestDto request) {
        openHours.setStartTime(request.getStartTime());
        openHours.setEndTime(request.getEndTime());
        return openHours;
    }
}
