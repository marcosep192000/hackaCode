package com.hackacode.marveland.service;

import java.util.List;

import com.hackacode.marveland.model.dto.request.CustomerRequestDto;
import com.hackacode.marveland.model.dto.response.CustomerResponseDto;
import com.hackacode.marveland.model.entity.Customer;

public interface ICustomerService {

	public void create(CustomerRequestDto requestDto, Long id);

	public Customer update(CustomerRequestDto requestDto, Long id);

	public List<CustomerResponseDto> getAll();

	public CustomerResponseDto getById(Long id);

	public CustomerResponseDto getByDni(int dni);

	public void delete(Long id);
}
