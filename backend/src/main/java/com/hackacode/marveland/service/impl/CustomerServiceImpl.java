package com.hackacode.marveland.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hackacode.marveland.model.dto.request.CustomerRequestDto;
import com.hackacode.marveland.model.dto.response.CustomerDetailsResponseDto;
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

	@Override
	public List<CustomerDetailsResponseDto> getCustomersByFilters() {
		return customerRepository.findAll().stream()
				.map(customer -> customerMapper.fromEntityToDto(customer))
				.collect(Collectors.toList());
	}

	@Override
	public CustomerDetailsResponseDto getCustomerById(Long id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Customer not found"));
		return customerMapper.fromEntityToDto(customer);
	}

	@Override
	@Transactional
	public CustomerDetailsResponseDto createCustomer(CustomerRequestDto request, String email) {
		if (customerRepository.existsByDni(request.getDni())) {
			throw new RuntimeException("Customer already exists");
		}
		AdminEmployee adminEmployee = adminEmployeeRepository.findByEmail(email);
		Customer customer = customerMapper.fromDtoToEntity(request, adminEmployee);
		adminEmployee.getCustomerList().add(customer);
		adminEmployeeRepository.save(adminEmployee);
		customerRepository.save(customer);
		return customerMapper.fromEntityToDto(customer);
	}

	@Override
	@Transactional
	public CustomerDetailsResponseDto updateCustomer(CustomerRequestDto request, Long id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Customer not found"));
		Customer updatedCustomer = customerMapper.update(customer, request);
		customerRepository.save(updatedCustomer);
		return customerMapper.fromEntityToDto(updatedCustomer);
	}

	@Override
	public void deleteCustomer(Long id) {
		if (!customerRepository.existsById(id)) {
			throw new RuntimeException("Customer not found");
		}
		customerRepository.deleteById(id);
	}
}

// @Override
// private GameDetailsResponseDto assignEmployeeToGame(Long gameEmployeeId, Long
// gameId) {
// GameEmployee gameEmployee =
// gameEmployeeRepository.findById(gameEmployeeId).orElseThrow();
// Game game = gameRepository.findById(gameId).orElseThrow();

// gameEmployee.setGame(game);
// game.getEmployees().add(gameEmployee);

// gameEmployeeRepository.save(gameEmployee);
// gameRepository.save(game);

// return gameMapper.fromEntityToDto(game);
// }

// @Override
// private GameDetailsResponseDto getMostPopularGame() {
// List<Game> games = gameRepository.findAll();

// Game mostPopularGame = null;
// int maxTicketsSold = 0;

// for (Game game : games) {
// int totalTickets = game.getTickets().size();
// if (totalTickets > maxTicketsSold) {
// maxTicketsSold = totalTickets;
// mostPopularGame = game;
// }
// }

// return gameMapper.fromEntityToDto(mostPopularGame);
// }
