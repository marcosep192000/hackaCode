package com.hackacode.marveland.service;

import java.util.List;

import com.hackacode.marveland.model.dto.request.OpenHoursRequestDto;
import com.hackacode.marveland.model.dto.response.OpenHoursResponseDto;

public interface IOpenHoursService {

    public List<OpenHoursResponseDto> getAll();

    public OpenHoursResponseDto getById(Long id);

    public OpenHoursResponseDto create(OpenHoursRequestDto request);

    public OpenHoursResponseDto update(OpenHoursRequestDto request, Long id);

    public void delete(Long id);
}
