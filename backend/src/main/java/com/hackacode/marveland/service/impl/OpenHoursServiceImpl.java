package com.hackacode.marveland.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hackacode.marveland.model.dto.request.OpenHoursRequestDto;
import com.hackacode.marveland.model.dto.response.OpenHoursResponseDto;
import com.hackacode.marveland.model.mapper.OpenHoursMapper;
import com.hackacode.marveland.repository.IOpenHoursRepository;
import com.hackacode.marveland.service.IOpenHoursService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OpenHoursServiceImpl implements IOpenHoursService {

    private final OpenHoursMapper openHoursMapper;

    private final IOpenHoursRepository openHoursRepository;

    @Override
    public List<OpenHoursResponseDto> getAllOpenHours() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllOpenHours'");
    }

    @Override
    public OpenHoursResponseDto getOpenHoursById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOpenHoursById'");
    }

    @Override
    public OpenHoursResponseDto createOpenHours(OpenHoursRequestDto request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createOpenHours'");
    }

    @Override
    public OpenHoursResponseDto updateOpenHours(OpenHoursRequestDto request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOpenHours'");
    }

    @Override
    public void deleteOpenHours(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteOpenHours'");
    }
}
