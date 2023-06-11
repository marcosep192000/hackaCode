package com.hackacode.marveland.service.impl;

import com.hackacode.marveland.model.dto.request.CustomerRequestDto;
import com.hackacode.marveland.model.dto.response.CustomerResponseDto;
import com.hackacode.marveland.model.entity.Customer;
import com.hackacode.marveland.model.mapper.CustomerMapper;
import com.hackacode.marveland.repository.CustomerRepository;
import com.hackacode.marveland.service.ICustomerService;
import com.hackacode.marveland.util.Exeptions.GeneralMessage;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CustomerMapper mapper;
	@Override
	public void create(CustomerRequestDto requestDto) {
		Optional<Customer> customer = Optional.ofNullable(customerRepository.findByDni(requestDto.getDni()));
		if (customer.isEmpty()){
          Customer customer1 = mapper.FromDtoToEntity(requestDto);
		  customerRepository.save(customer1);
		}else{
		throw new RuntimeException("this ID already exists");}
	}


	@Override
	@Transactional
	public Customer Update(CustomerRequestDto requestDto, Long id) {
		Customer customer = customerRepository.findById(id).orElseThrow(()->new RuntimeException("Id not exist!"));
		Customer updateCustomer = mapper.Update(customer,requestDto);
	    customerRepository.save(updateCustomer);
		return updateCustomer;
	}



	@Override
	public List<CustomerResponseDto> getAll() {
		return null;
	}

	@Override
	public CustomerResponseDto getById(Long id) {
		Optional<Customer> customer = Optional.ofNullable(Optional.of(customerRepository.getReferenceById(id)).orElseThrow(() -> new RuntimeException("dni not exist")));
		if (customer.isPresent()) {
			CustomerResponseDto customerResponse = mapper.fromEntityToDto(customer.get());
			return customerResponse;
		}
	throw new RuntimeException("id not exist");
	}

	@Override
	public CustomerResponseDto getByDni(int dni) {
		Optional<Customer> customer = Optional.ofNullable(customerRepository.findByDni(dni));
		if (customer.isPresent()) {
			CustomerResponseDto customerResponse = mapper.fromEntityToDto(customer.get());
			return customerResponse;
		}else {
		throw new RuntimeException("Dni not exist");}
	}

	@Override
	public void delete(Long id) {
		Customer customer = customerRepository.findById(id).orElseThrow(()-> new RuntimeException("Id bot exist!"));
		customerRepository.deleteById(id);
	}
}
