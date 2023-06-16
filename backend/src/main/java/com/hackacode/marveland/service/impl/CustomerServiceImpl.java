package com.hackacode.marveland.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hackacode.marveland.model.dto.request.CustomerRequestDto;
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

	private final CustomerMapper customerMapper;

	private final ICustomerRepository customerRepository;

	private final IAdminEmployeeRepository adminEmployeeRepository;

	private Customer findCustomerById(Long id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Customer not found"));
	}

	@Override
	public List<CustomerListResponseDto> getCustomersByFilters() {
		return customerRepository.findAll().stream()
				.map(customer -> customerMapper.fromEntityToDto(customer))
				.collect(Collectors.toList());
	}

	@Override
	public CustomerListResponseDto getCustomerById(Long id) {
		Customer customer = findCustomerById(id);
		return customerMapper.fromEntityToDto(customer);
	}

	@Override
	@Transactional
	public CustomerListResponseDto createCustomer(CustomerRequestDto request, String email) {
		if (customerRepository.existsByDni(request.getDni())) {
			throw new RuntimeException("Customer already exists");
		}
		AdminEmployee adminEmployee = adminEmployeeRepository.findByEmail(email);
		Customer customer = customerMapper.fromDtoToEntity(request, adminEmployee);
		adminEmployee.getCustomers().add(customer);
		adminEmployeeRepository.save(adminEmployee);
		customerRepository.save(customer);
		return customerMapper.fromEntityToDto(customer);
	}

	@Override
	@Transactional
	public CustomerListResponseDto updateCustomer(CustomerRequestDto request, Long id) {
		Customer customer = findCustomerById(id);
		Customer updatedCustomer = customerMapper.updateCustomer(customer, request);
		customerRepository.save(updatedCustomer);
		return customerMapper.fromEntityToDto(updatedCustomer);
	}

	@Override
	public void deleteCustomer(Long id) {
		customerRepository.delete(findCustomerById(id));
	}
}