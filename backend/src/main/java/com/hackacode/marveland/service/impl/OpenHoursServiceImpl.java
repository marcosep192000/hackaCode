package com.hackacode.marveland.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hackacode.marveland.model.dto.request.OpenHoursRequestDto;
import com.hackacode.marveland.model.dto.response.OpenHoursResponseDto;
import com.hackacode.marveland.model.entity.OpenHours;
import com.hackacode.marveland.model.mapper.OpenHoursMapper;
import com.hackacode.marveland.repository.IOpenHoursRepository;
import com.hackacode.marveland.service.IOpenHoursService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OpenHoursServiceImpl implements IOpenHoursService {

    private final OpenHoursMapper openHoursMapper;
    private final IOpenHoursRepository openHoursRepository;

    @Override
    public List<OpenHoursResponseDto> getOpenHoursByFilters() {
        List<OpenHours> openHoursList = openHoursRepository.findOpenHoursByFilters();
        return openHoursMapper.mapToResponseDtoList(openHoursList);
    }

    @Override
    public OpenHoursResponseDto getOpenHoursById(Long id) {
        OpenHours openHours = openHoursRepository.findOpenHoursById(id);
        return openHoursMapper.mapToResponseDto(openHours);
    }

    @Override
    public OpenHoursResponseDto createOpenHours(OpenHoursRequestDto request) {
        OpenHours openHours = openHoursMapper.mapToEntity(request);
        OpenHours savedOpenHours = openHoursRepository.save(openHours);
        return openHoursMapper.mapToResponseDto(savedOpenHours);
    }

    @Override
    public OpenHoursResponseDto updateOpenHours(OpenHoursRequestDto request, Long id) {
        OpenHours existingOpenHours = openHoursRepository.findOpenHoursById(id);
        existingOpenHours.setStartTime(request.getStartTime());
        existingOpenHours.setEndTime(request.getEndTime());
        OpenHours updatedOpenHours = openHoursRepository.save(existingOpenHours);
        return openHoursMapper.mapToResponseDto(updatedOpenHours);
    }

    @Override
    public void deleteOpenHours(Long id) {
        // Aquí implementa la lógica para eliminar un horario de apertura por su ID
        // Utiliza openHoursRepository para buscar y eliminar el horario de apertura
        // Ejemplo de implementación:
        openHoursRepository.deleteById(id);
    }
}
