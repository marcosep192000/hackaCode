package com.hackacode.marveland.service;

import java.util.List;

import com.hackacode.marveland.model.dto.request.EmployeeRequestDto;
import com.hackacode.marveland.model.dto.response.EmployeeListResponseDto;

public interface IEmployeeService {

    public List<EmployeeListResponseDto> getByFilters();

    public EmployeeListResponseDto getById(Long id);

    public EmployeeListResponseDto update(EmployeeRequestDto request, Long id);

    public void delete(Long id);
}
