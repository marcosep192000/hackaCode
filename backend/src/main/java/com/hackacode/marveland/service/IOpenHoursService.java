package com.hackacode.marveland.service;

import java.util.List;

import com.hackacode.marveland.model.dto.request.OpenHoursRequestDto;
import com.hackacode.marveland.model.dto.response.OpenHoursResponseDto;

public interface IOpenHoursService {

    public void create(OpenHoursRequestDto openHoursRequestDto);

    public OpenHoursResponseDto update(Long id, OpenHoursRequestDto openHoursRequestDto);

    public List<OpenHoursResponseDto> getAll();

    public OpenHoursResponseDto getById(Long id);

    public void delete(Long id);
}
