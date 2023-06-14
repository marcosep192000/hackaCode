package com.hackacode.marveland.model.mapper;

import org.springframework.stereotype.Component;

import com.hackacode.marveland.model.dto.request.CustomerRequestDto;
import com.hackacode.marveland.model.dto.response.CustomerResponseDto;
import com.hackacode.marveland.model.entity.AdminEmployee;
import com.hackacode.marveland.model.entity.Customer;

@Component
public class CustomerMapper {
	
	public Customer FromDtoToEntity(CustomerRequestDto requestDto, AdminEmployee adminEmployee) {
		return Customer.builder()
				.dni(requestDto.getDni())
				.email(requestDto.getEmail())
				.firstName(requestDto.getFirstName())
				.birthDate(requestDto.getBirthDate())
				.lastName(requestDto.getLastName())
				.adminEmployee(adminEmployee)
				.build();
	}

	public CustomerResponseDto fromEntityToDto(Customer customer) {
		return CustomerResponseDto.builder()
				.id(customer.getId())
				.birthDate(customer.getBirthDate())
				.dni(customer.getDni())
				.lastName(customer.getLastName())
				.firstName(customer.getFirstName())
				.build();
	}

	public Customer Update(Customer customer, CustomerRequestDto customerRequestDto) {
		customer.setBirthDate(customerRequestDto.getBirthDate());
		customer.setDni(customerRequestDto.getDni());
		customer.setLastName(customerRequestDto.getLastName());
		customer.setFirstName(customerRequestDto.getFirstName());
		return customer;
	}
}
