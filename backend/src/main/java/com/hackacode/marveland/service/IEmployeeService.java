package com.hackacode.marveland.service;

import java.util.List;

import com.hackacode.marveland.model.dto.request.EmployeeRequestDto;
import com.hackacode.marveland.model.dto.request.MessageRequestDto;
import com.hackacode.marveland.model.dto.response.EmployeeResponseDto;
import com.hackacode.marveland.model.entity.Employee;
import com.hackacode.marveland.model.entity.Message;

public interface IEmployeeService {

    public List<EmployeeResponseDto> getByFilters();

    Employee findById(Long id);

    public List<EmployeeResponseDto> getAll();

    public EmployeeResponseDto getById(Long id);

    public EmployeeResponseDto update(EmployeeRequestDto request, Long id);

    public void delete(Long id);

    public void requestToAdmin(MessageRequestDto request, Long id);

    public List<Message> getMessages();

    public String getRoleByToken(String token);
}
