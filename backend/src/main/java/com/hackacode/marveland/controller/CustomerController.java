package com.hackacode.marveland.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackacode.marveland.config.jwt.JwtProvider;
import com.hackacode.marveland.model.dto.request.CustomerRequestDto;
import com.hackacode.marveland.model.dto.response.CustomerDetailsResponseDto;
import com.hackacode.marveland.service.ICustomerService;
import com.hackacode.marveland.util.exceptions.GeneralMessage;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

	private final ICustomerService customerService;

	private final JwtProvider jwtProvider;

	@GetMapping("/filters")
	public ResponseEntity<List<CustomerDetailsResponseDto>> getCustomersByFilters() {
		List<CustomerDetailsResponseDto> response = customerService.getCustomersByFilters();
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerDetailsResponseDto> getCustomerById(@PathVariable Long id) {
		CustomerDetailsResponseDto response = customerService.getCustomerById(id);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/create")
	public ResponseEntity<CustomerDetailsResponseDto> createCustomer(@RequestHeader("Authorization") String token,
			@RequestBody CustomerRequestDto request) {
		String email = jwtProvider.extractUsername(token.substring(7));
		CustomerDetailsResponseDto response = customerService.createCustomer(request, email);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PatchMapping("/update/{id}")
	public ResponseEntity<CustomerDetailsResponseDto> updateCustomer(@PathVariable Long id,
			@RequestBody CustomerRequestDto request) {
		CustomerDetailsResponseDto response = customerService.updateCustomer(request, id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<GeneralMessage> deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new GeneralMessage("Customer successfully deleted"));
	}
}