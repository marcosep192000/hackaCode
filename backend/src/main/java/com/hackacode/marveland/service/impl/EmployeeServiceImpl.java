package com.hackacode.marveland.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hackacode.marveland.config.jwt.JwtProvider;
import com.hackacode.marveland.model.dto.request.EmployeeRequestDto;
import com.hackacode.marveland.model.dto.request.MessageRequestDto;
import com.hackacode.marveland.model.dto.response.EmployeeResponseDto;
import com.hackacode.marveland.model.entity.Employee;
import com.hackacode.marveland.model.entity.Message;
import com.hackacode.marveland.model.entity.User;
import com.hackacode.marveland.model.mapper.EmployeeMapper;
import com.hackacode.marveland.repository.IEmployeeRepository;
import com.hackacode.marveland.repository.IMessageRepository;
import com.hackacode.marveland.repository.IUserRepository;
import com.hackacode.marveland.service.IEmployeeService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

    private final EmployeeMapper employeeMapper;

    private final IEmployeeRepository employeeRepository;

    private final IMessageRepository messageRepository;

    private final IUserRepository userRepository;

    private final JwtProvider jwtProvider;

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public List<EmployeeResponseDto> getAll() {
        return employeeRepository.findAll().stream()
                .map(employee -> employeeMapper.fromEntityToDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeResponseDto> getByFilters() {
        return employeeRepository.findAll().stream()
                .map(employee -> employeeMapper.fromEntityToDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public void requestToAdmin(MessageRequestDto request, Long id) {
        Employee employee = findById(id);
        Message message = Message.builder()
                .messageDate(LocalDate.now())
                .employeeFullName(employee.getFirstName() + " " + employee.getLastName())
                .details(request.getDetails())
                .customerRequest(request.getCustomerRequest())
                .build();
        messageRepository.save(message);
    }

    @Override
    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    @Override
    public EmployeeResponseDto getById(Long id) {
        Employee Employee = findById(id);
        return employeeMapper.fromEntityToDto(Employee);
    }

    @Override
    @Transactional
    public EmployeeResponseDto update(EmployeeRequestDto request, Long id) {
        Employee employee = findById(id);
        Employee updatedEmployee = employeeMapper.update(employee, request);
        employeeRepository.save(updatedEmployee);
        return employeeMapper.fromEntityToDto(updatedEmployee);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.delete(findById(id));
    }

    @Override
    public String getRoleByToken(String token) {
        String email = jwtProvider.extractUsername(token.substring(7));
        User user = userRepository.findByUsername(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return user.getRole();
    }
}