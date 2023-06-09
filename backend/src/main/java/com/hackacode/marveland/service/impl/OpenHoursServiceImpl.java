package com.hackacode.marveland.service.impl;

import com.hackacode.marveland.model.dto.request.OpenHoursRequestDto;
import com.hackacode.marveland.model.dto.response.GameResponseDto;
import com.hackacode.marveland.model.dto.response.OpenHoursResponseDto;
import com.hackacode.marveland.model.entity.Game;
import com.hackacode.marveland.model.entity.OpenHours;
import com.hackacode.marveland.model.mapper.OpenHoursMapper;
import com.hackacode.marveland.repository.IOpenHoursRepository;
import com.hackacode.marveland.service.IOpenHoursService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OpenHoursServiceImpl implements IOpenHoursService {

    private final OpenHoursMapper openHoursMapper;

    private final IOpenHoursRepository openHoursRepository;
    @Transactional
    public void createOpenHours(OpenHoursRequestDto openHoursRequestDto) {
        OpenHours openHours = openHoursMapper.fromDtoToEntity(openHoursRequestDto);
        openHoursRepository.save(openHours);
    }

    @Override
    public OpenHoursResponseDto updateHours(Long id, OpenHoursRequestDto openHoursRequestDto) {
        OpenHours openHours = openHoursRepository.findById(id).orElseThrow();
        OpenHours updateHours = openHoursMapper.updateOpenHours(openHours, openHoursRequestDto);
        openHoursRepository.save(updateHours);
        OpenHoursResponseDto response = openHoursMapper.fromEntityToDto(updateHours);
        return response;
    }

    @Override
    public List<OpenHoursResponseDto> getAllOpenHours() {
        List<OpenHours> openHours = openHoursRepository.findAll();
        List<OpenHoursResponseDto> openHoursResponseDtoList = new ArrayList<>();
        openHours.forEach(openHour -> {
            OpenHoursResponseDto response = openHoursMapper.fromEntityToDto(openHour);
            openHoursResponseDtoList.add(response);
        });
        return openHoursResponseDtoList;
    }

    @Override
    public OpenHoursResponseDto getOpenHoursById(Long id) {
        Optional<OpenHours> openHours = openHoursRepository.findById(id);
        OpenHoursResponseDto response = openHoursMapper.fromEntityToDto(openHours.get());
        return response;
    }

    @Override
    public void deleteOpenHours(Long id) {
        openHoursRepository.deleteById(id);
    }
}