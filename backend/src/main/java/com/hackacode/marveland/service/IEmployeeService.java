package com.hackacode.marveland.service;

import java.util.List;

import com.hackacode.marveland.model.dto.request.EmployeeRequestDto;
import com.hackacode.marveland.model.dto.response.EmployeeDetailsResponseDto;
import com.hackacode.marveland.model.dto.response.EmployeeListResponseDto;

public interface IEmployeeService {

    public List<EmployeeListResponseDto> getEmployeesByFilters();

    public EmployeeDetailsResponseDto getEmployeeById(Long id);

    public EmployeeDetailsResponseDto createEmployee(EmployeeRequestDto request);

    public EmployeeDetailsResponseDto updateEmployee(EmployeeRequestDto request, Long id);

    public void deleteEmployee(Long id);
}
