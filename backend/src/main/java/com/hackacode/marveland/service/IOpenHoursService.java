package com.hackacode.marveland.service;

import java.util.List;

import com.hackacode.marveland.model.dto.request.OpenHoursRequestDto;
import com.hackacode.marveland.model.dto.response.OpenHoursResponseDto;

public interface IOpenHoursService {

    public List<OpenHoursResponseDto> getAllOpenHours();

    public OpenHoursResponseDto getOpenHoursById(Long id);

    public OpenHoursResponseDto createOpenHours(OpenHoursRequestDto request);

    public OpenHoursResponseDto updateOpenHours(OpenHoursRequestDto request, Long id);

    public void deleteOpenHours(Long id);
}
