package com.hackacode.marveland.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.hackacode.marveland.model.entity.PurchaseDetails;
import com.hackacode.marveland.repository.IPurchaseDetailsRepository;
import com.hackacode.marveland.service.IPurchaseDetailsService;
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

	private final CustomerMapper customerMapper;

	private final ICustomerRepository customerRepository;

	private final IAdminEmployeeRepository adminEmployeeRepository;

	private final EmailService emailService;

	private final IPurchaseDetailsService purchaseService;
	private Customer findById(Long id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Customer not found"));
	}

	@Override
	public List<CustomerResponseDto> getByFilters() {
		return customerRepository.findAll().stream()
				.map(customer -> customerMapper.fromEntityToDto(customer))
				.collect(Collectors.toList());
	}

	@Override
	public List<CustomerResponseDto> getAll() {
		return customerRepository.findAll().stream()
				.map(customer -> customerMapper.fromEntityToDto(customer))
				.collect(Collectors.toList());
	}

	@Override
	public CustomerResponseDto getById(Long id) {
		Customer customer = findById(id);
		return customerMapper.fromEntityToDto(customer);
	}

	@Transactional
	public CustomerResponseDto create(CustomerRequestDto request, String email) {
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

	@Transactional
	public CustomerResponseDto update(CustomerRequestDto request, Long id) {
		Customer customer = findById(id);
		Customer updatedCustomer = customerMapper.update(customer, request);
		customerRepository.save(updatedCustomer);
		return customerMapper.fromEntityToDto(updatedCustomer);
	}

	@Override
	public CustomerResponseDto morePurchasesByYear(int year) {
		List<Customer> customers = customerRepository.findAll();
		Customer response = null;
		int maxTickets = 0;
		for (Customer customer : customers) {
			for (PurchaseDetails purchases : customer.getPurchases()) {
				if (purchases.getPurchaseDate().getYear() == year) {
					int totalTickets = customer.getPurchases().size();
					if (totalTickets > maxTickets) {
						maxTickets = totalTickets;
						response = customer;
					}
				}
			}
		}
		return customerMapper.fromEntityToDto(response);
	}

	@Override
	public List<CustomerResponseDto> findByBirthdate() {
		List<Customer> customers = customerRepository.findAll();
		List<CustomerResponseDto> sendEmailCustomer = new ArrayList<>();
		for (Customer customer : customers){
			Period period = Period.between(customer.getBirthdate(), LocalDate.now());
			if (period.getDays() == 360){
				sendEmailCustomer.add(customerMapper.fromEntityToDto(customer));
			}
		}
		return sendEmailCustomer;
	}

	@Override
	public void sendCouponEmail(){
		for (CustomerResponseDto customer : findByBirthdate()){
			emailService.sendMail(customer.getEmail(),
					"MARVELAND - FELIZ CUMPLEAÑOS",
					"FELIZ CUMPLEAÑOS \n" +
							"TENES UN CUPON CON DESCUENTO POR TU CUMPLEAÑOS\n" +
							"CUPON: FELIZCUMPLE\n" +
							"\n" +
							"Valido por el dia de tu cumpleaños\n");
		}
	}

	@Override
	public void delete(Long id) {
		customerRepository.delete(findById(id));
	}


}