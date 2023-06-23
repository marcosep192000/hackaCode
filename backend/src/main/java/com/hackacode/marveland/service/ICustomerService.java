package com.hackacode.marveland.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.hackacode.marveland.model.dto.request.CustomerRequestDto;
import com.hackacode.marveland.model.dto.response.CustomerResponseDto;
import com.hackacode.marveland.model.entity.Customer;

public interface ICustomerService {

	public List<CustomerResponseDto> getByFilters();

	public List<CustomerResponseDto> getAll();
	public CustomerResponseDto getById(Long id);

	public CustomerResponseDto create(CustomerRequestDto request, String email);

	public CustomerResponseDto update(CustomerRequestDto request, Long id);

	public List<CustomerResponseDto> findByBirthdate();

	void sendCouponEmail();

	public void delete(Long id);
}
