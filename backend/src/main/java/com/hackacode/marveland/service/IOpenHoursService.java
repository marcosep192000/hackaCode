package com.hackacode.marveland.service;

import com.hackacode.marveland.model.dto.request.OpenHoursRequestDto;
import com.hackacode.marveland.model.dto.response.OpenHoursResponseDto;

import java.util.List;

public interface IOpenHoursService {

    public void createOpenHours(OpenHoursRequestDto openHoursRequestDto);

    public OpenHoursResponseDto updateHours(Long id, OpenHoursRequestDto openHoursRequestDto);

    public List<OpenHoursResponseDto> getAllOpenHours();

    public OpenHoursResponseDto getOpenHoursById(Long id);

    public void deleteOpenHours(Long id);


}
