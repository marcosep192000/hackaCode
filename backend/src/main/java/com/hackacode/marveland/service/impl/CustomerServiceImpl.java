package com.hackacode.marveland.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hackacode.marveland.model.dto.request.CustomerRequestDto;
import com.hackacode.marveland.model.dto.response.CustomerResponseDto;
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

	private final IAdminEmployeeRepository adminEmployeeService;

	@Override
	@Transactional
	public void create(CustomerRequestDto customerRequestDto, Long adminId) {
		AdminEmployee adminEmployee = adminEmployeeService.findById(adminId)
				.orElseThrow(() -> new RuntimeException("Id does not exist"));
		Optional<Customer> customer = Optional.ofNullable(customerRepository.findByDni(customerRequestDto.getDni()));
		if (customer.isEmpty()) {
			Customer customer1 = customerMapper.FromDtoToEntity(customerRequestDto, adminEmployee);
			customerRepository.save(customer1);
			adminEmployee.getCustomerList().add(customer1);
		} else {
			throw new RuntimeException("Id already exists");
		}
	}

	@Override
	@Transactional
	public CustomerResponseDto update(CustomerRequestDto requestDto, Long id) {
		Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not exist!"));
		Customer updatedCustomer = customerMapper.update(customer, requestDto);
		customerRepository.save(updatedCustomer);
		return customerMapper.fromEntityToDto(updatedCustomer);
	}

	@Override
	public List<CustomerResponseDto> getAll() {
		List<Customer> customers = customerRepository.findAll();
		List<CustomerResponseDto> customerResponseDtoList = new ArrayList<>();
		customers.forEach(customer -> {
			CustomerResponseDto customerDto = customerMapper.fromEntityToDto(customer);
			customerResponseDtoList.add(customerDto);
		});
		return customerResponseDtoList;
	}

	@Override
	public CustomerResponseDto getById(Long id) {
		Optional<Customer> customer = Optional.ofNullable(Optional.of(customerRepository.getReferenceById(id))
				.orElseThrow(() -> new RuntimeException("Dni does not exist")));
		if (customer.isPresent()) {
			CustomerResponseDto customerResponse = customerMapper.fromEntityToDto(customer.get());
			return customerResponse;
		}
		throw new RuntimeException("id does not exist");
	}

	@Override
	public CustomerResponseDto getByDni(Integer dni) {
		Optional<Customer> customer = Optional.ofNullable(customerRepository.findByDni(dni));
		if (customer.isPresent()) {
			CustomerResponseDto customerResponse = customerMapper.fromEntityToDto(customer.get());
			return customerResponse;
		} else {
			throw new RuntimeException("Dni does not exist");
		}
	}

	@Override
	public void delete(Long id) {
		customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Id does not exist"));
		customerRepository.deleteById(id);
	}
}
