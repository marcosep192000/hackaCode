package com.hackacode.marveland.service;

import java.util.List;

import com.hackacode.marveland.model.dto.request.EmployeeRequestDto;
import com.hackacode.marveland.model.dto.response.EmployeeListResponseDto;

public interface IEmployeeService {

    public List<EmployeeListResponseDto> getEmployeesByFilters();

    public EmployeeListResponseDto getEmployeeById(Long id);

    public EmployeeListResponseDto updateEmployee(EmployeeRequestDto request, Long id);

    public void deleteEmployee(Long id);
}
