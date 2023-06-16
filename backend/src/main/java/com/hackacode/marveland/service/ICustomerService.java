package com.hackacode.marveland.service;

import java.util.List;

import com.hackacode.marveland.model.dto.request.CustomerRequestDto;
import com.hackacode.marveland.model.dto.response.CustomerListResponseDto;

public interface ICustomerService {

	public List<CustomerListResponseDto> getCustomersByFilters();

	public CustomerListResponseDto getCustomerById(Long id);

	public CustomerListResponseDto createCustomer(CustomerRequestDto request, String email);

	public CustomerListResponseDto updateCustomer(CustomerRequestDto request, Long id);

	public void deleteCustomer(Long id);
}
