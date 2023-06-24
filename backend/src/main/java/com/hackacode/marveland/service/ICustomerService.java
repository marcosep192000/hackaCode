package com.hackacode.marveland.service;

import java.util.List;

import com.hackacode.marveland.model.dto.request.CustomerRequestDto;
import com.hackacode.marveland.model.dto.response.CustomerResponseDto;

public interface ICustomerService {

	public List<CustomerResponseDto> getByFilters();

	public List<CustomerResponseDto> getAll();
	public CustomerResponseDto getById(Long id);

	public CustomerResponseDto create(CustomerRequestDto request, String email);

	public CustomerResponseDto update(CustomerRequestDto request, Long id);

	public List<CustomerResponseDto> findByBirthdate();

	public CustomerResponseDto morePurchasesByYear(int year);

	public CustomerResponseDto morePurchasesByMonth(int month, int year);

	void sendCouponEmail();

	public void delete(Long id);
}
