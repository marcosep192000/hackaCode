package com.hackacode.marveland.model.mapper;

import org.springframework.stereotype.Component;

import com.hackacode.marveland.model.dto.request.CustomerRequestDto;
import com.hackacode.marveland.model.dto.response.CustomerResponseDto;
import com.hackacode.marveland.model.entity.AdminEmployee;
import com.hackacode.marveland.model.entity.Customer;

@Component
public class CustomerMapper {

	public Customer FromDtoToEntity(CustomerRequestDto customerRequestDto, AdminEmployee adminEmployee) {
		return Customer.builder()
				.dni(customerRequestDto.getDni())
				.firstName(customerRequestDto.getFirstName())
				.lastName(customerRequestDto.getLastName())
				.dni(customerRequestDto.getDni())
				.email(customerRequestDto.getEmail())
				.phone(customerRequestDto.getPhone())
				.birthdate(customerRequestDto.getBirthdate())
				.adminEmployee(adminEmployee)
				.build();
	}

	public CustomerResponseDto fromEntityToDto(Customer customer) {
		return CustomerResponseDto.builder()
				.id(customer.getId())
				.firstName(customer.getFirstName())
				.lastName(customer.getLastName())
				.dni(customer.getDni())
				.email(customer.getEmail())
				.phone(customer.getPhone())
				.birthdate(customer.getBirthdate())
				.purchases(customer.getPurchases())
				.build();
	}

	public Customer update(Customer customer, CustomerRequestDto customerRequestDto) {
		customer.setFirstName(customerRequestDto.getFirstName());
		customer.setLastName(customerRequestDto.getLastName());
		customer.setDni(customerRequestDto.getDni());
		customer.setPhone(customerRequestDto.getPhone());
		customer.setBirthdate(customerRequestDto.getBirthdate());
		return customer;
	}
}
