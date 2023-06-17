package com.hackacode.marveland.service.impl;

import java.util.List;
import java.util.stream.Collectors;

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

    private OpenHours findById(Long id) {
        return openHoursRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Open Hours not found"));
    }

    @Override
    public List<OpenHoursResponseDto> getAll() {
        return openHoursRepository.findAll().stream()
                .map(openHours -> openHoursMapper.fromEntityToDto(openHours))
                .collect(Collectors.toList());
    }

    @Override
    public OpenHoursResponseDto getById(Long id) {
        OpenHours openHours = findById(id);
        return openHoursMapper.fromEntityToDto(openHours);
    }

    @Override
    @Transactional
    public OpenHoursResponseDto create(OpenHoursRequestDto request) {
        OpenHours openHours = openHoursMapper.fromDtoToEntity(request);
        openHoursRepository.save(openHours);
        return openHoursMapper.fromEntityToDto(openHours);
    }

    @Transactional
    public OpenHoursResponseDto update(OpenHoursRequestDto request, Long id) {
        OpenHours openHours = findById(id);
        OpenHours updatedOpenHours = openHoursMapper.update(openHours, request);
        openHoursRepository.save(updatedOpenHours);
        return openHoursMapper.fromEntityToDto(updatedOpenHours);
    }

    @Override
    public void delete(Long id) {
        openHoursRepository.delete(findById(id));
    }
}
