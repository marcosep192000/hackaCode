package com.hackacode.marveland.service;

import com.hackacode.marveland.model.dto.request.CustomerRequestDto;
import com.hackacode.marveland.model.dto.response.CustomerResponseDto;
import com.hackacode.marveland.model.entity.Customer;

import java.util.List;

public interface ICustomerService {
	void create(CustomerRequestDto requestDto);
	Customer Update(CustomerRequestDto requestDto, Long id );

	public List<CustomerResponseDto> getAll();

	public CustomerResponseDto getById(Long id);

	public CustomerResponseDto getByDni(int dni);
	public void delete(Long id);
}
