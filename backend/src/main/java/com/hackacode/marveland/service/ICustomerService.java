package com.hackacode.marveland.service;

import java.util.List;

import com.hackacode.marveland.model.dto.request.CustomerRequestDto;
import com.hackacode.marveland.model.dto.response.CustomerDetailsResponseDto;
import com.hackacode.marveland.model.dto.response.CustomerListResponseDto;

public interface ICustomerService {

	public List<CustomerDetailsResponseDto> getCustomersByFilters();

	public CustomerDetailsResponseDto getCustomerById(Long id);

	public CustomerDetailsResponseDto createCustomer(CustomerRequestDto request, String email);

	public CustomerDetailsResponseDto updateCustomer(CustomerRequestDto request, Long id);

	public void deleteCustomer(Long id);
}
