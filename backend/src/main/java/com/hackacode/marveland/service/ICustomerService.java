package com.hackacode.marveland.service;

import java.util.List;

import com.hackacode.marveland.model.dto.request.CustomerRequestDto;
import com.hackacode.marveland.model.dto.response.CustomerListResponseDto;

public interface ICustomerService {

	public List<CustomerListResponseDto> getByFilters();

	public CustomerListResponseDto getById(Long id);

	public CustomerListResponseDto create(CustomerRequestDto request, String email);

	public CustomerListResponseDto update(CustomerRequestDto request, Long id);

	public void delete(Long id);
}
