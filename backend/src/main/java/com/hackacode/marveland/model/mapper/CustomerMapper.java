package com.hackacode.marveland.model.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.hackacode.marveland.model.dto.request.CustomerRequestDto;
import com.hackacode.marveland.model.dto.response.CustomerListResponseDto;
import com.hackacode.marveland.model.entity.AdminEmployee;
import com.hackacode.marveland.model.entity.Customer;

@Component
public class CustomerMapper {

	public Customer fromDtoToEntity(CustomerRequestDto request, AdminEmployee adminEmployee) {
		return Customer.builder()
				.firstName(request.getFirstName())
				.lastName(request.getLastName())
				.dni(request.getDni())
				.email(request.getEmail())
				.phone(request.getPhone())
				.birthdate(request.getBirthdate())
				.registrationDate(LocalDateTime.now())
				.adminEmployee(adminEmployee)
				.build();
	}

	public CustomerListResponseDto fromEntityToDto(Customer customer) {
		return CustomerListResponseDto.builder()
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

	public Customer updateCustomer(Customer customer, CustomerRequestDto request) {
		customer.setFirstName(request.getFirstName());
		customer.setLastName(request.getLastName());
		customer.setDni(request.getDni());
		customer.setEmail(request.getEmail());
		customer.setPhone(request.getPhone());
		customer.setBirthdate(request.getBirthdate());
		return customer;
	}
}
