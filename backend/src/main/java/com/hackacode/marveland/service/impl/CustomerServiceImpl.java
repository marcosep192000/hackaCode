package com.hackacode.marveland.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hackacode.marveland.model.dto.request.CustomerRequestDto;
import com.hackacode.marveland.model.dto.response.CustomerDetailsResponseDto;
import com.hackacode.marveland.model.dto.response.CustomerListResponseDto;
import com.hackacode.marveland.model.entity.AdminEmployee;
import com.hackacode.marveland.model.entity.Customer;
import com.hackacode.marveland.model.mapper.CustomerMapper;
import com.hackacode.marveland.repository.IAdminEmployeeRepository;
import com.hackacode.marveland.repository.ICustomerRepository;
import com.hackacode.marveland.service.ICustomerService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

	private final ICustomerRepository customerRepository;

	private final CustomerMapper customerMapper;

	private final IAdminEmployeeRepository adminEmployeeRepository;

	@Override
	public List<CustomerDetailsResponseDto> getCustomersByFilters() {
		List<Customer> customers = customerRepository.findAll();
		List<CustomerDetailsResponseDto> customerResponseDtoList = new ArrayList<>();
		customers.forEach(customer -> {
			CustomerDetailsResponseDto customerDto = customerMapper.fromEntityToDto(customer);
			customerResponseDtoList.add(customerDto);
		});
		return customerResponseDtoList;
	}

	@Override
	public CustomerDetailsResponseDto getCustomerById(Long id) {
		Optional<Customer> customer = Optional.ofNullable(Optional.of(customerRepository.getReferenceById(id))
				.orElseThrow(() -> new RuntimeException("Dni does not exist")));
		if (customer.isPresent()) {
			CustomerDetailsResponseDto customerResponse = customerMapper.fromEntityToDto(customer.get());
			return customerResponse;
		}
		throw new RuntimeException("id does not exist");
	}

	@Override
	@Transactional
	public CustomerDetailsResponseDto createCustomer(CustomerRequestDto customerRequestDto, String email) {
		boolean customerExists = customerRepository.existsByDni(customerRequestDto.getDni());
		if (customerExists) {
			throw new RuntimeException("Customer already exists");
		}

		AdminEmployee adminEmployee = adminEmployeeRepository.findByEmail(email);
		Customer customer = customerMapper.FromDtoToEntity(customerRequestDto, adminEmployee);
		customerRepository.save(customer);
		adminEmployee.getCustomerList().add(customer);
		return customerMapper.fromEntityToDto(customer);
	}

	@Override
	@Transactional
	public CustomerDetailsResponseDto updateCustomer(CustomerRequestDto requestDto, Long id) {
		Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not exist!"));
		Customer updatedCustomer = customerMapper.update(customer, requestDto);
		customerRepository.save(updatedCustomer);
		return customerMapper.fromEntityToDto(updatedCustomer);
	}

	@Override
	public void deleteCustomer(Long id) {
		customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Id does not exist"));
		customerRepository.deleteById(id);
	}
}
