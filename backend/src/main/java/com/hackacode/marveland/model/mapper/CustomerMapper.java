package com.hackacode.marveland.model.mapper;

import com.hackacode.marveland.model.dto.request.CustomerRequestDto;
import com.hackacode.marveland.model.dto.response.CustomerResponseDto;
import com.hackacode.marveland.model.entity.Customer;
import com.hackacode.marveland.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerMapper {
	private final CustomerRepository customerRepository;
	public CustomerMapper(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	public Customer FromDtoToEntity(CustomerRequestDto requestDto){
	return Customer.builder()
			.dni(requestDto.getDni())
			.email(requestDto.getEmail())
			.firstName(requestDto.getFirstName())
			.birthDate(requestDto.getBirthDate())
			.lastName(requestDto.getLastName())
			.build();
	}
	public CustomerResponseDto fromEntityToDto (Customer customer){
		return CustomerResponseDto.builder()
				.id(customer.getId())
				.birthDate(customer.getBirthDate())
				.dni(customer.getDni())
				.lastName(customer.getLastName())
				.firstName(customer.getFirstName())
				.build();
	}

	public Customer Update(Customer customer, CustomerRequestDto customerRequestDto ) {
		customer.setBirthDate(customerRequestDto.getBirthDate());
		customer.setDni(customerRequestDto.getDni());
		customer.setLastName(customerRequestDto.getLastName());
		customer.setFirstName(customerRequestDto.getFirstName());
		return customer;
	}
}
