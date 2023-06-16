package com.hackacode.marveland.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackacode.marveland.config.jwt.JwtProvider;
import com.hackacode.marveland.model.dto.request.CustomerRequestDto;
import com.hackacode.marveland.model.dto.response.CustomerListResponseDto;
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
	public ResponseEntity<List<CustomerListResponseDto>> getCustomersByFilters() {
		List<CustomerListResponseDto> response = customerService.getCustomersByFilters();
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerListResponseDto> getCustomerById(@PathVariable Long id) {
		CustomerListResponseDto response = customerService.getCustomerById(id);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/create")
	public ResponseEntity<CustomerListResponseDto> createCustomer(@RequestHeader("Authorization") String token,
			@RequestBody CustomerRequestDto request) {
		String email = jwtProvider.extractUsername(token.substring(7));
		CustomerListResponseDto response = customerService.createCustomer(request, email);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<CustomerListResponseDto> updateCustomer(@PathVariable Long id,
			@RequestBody CustomerRequestDto request) {
		CustomerListResponseDto response = customerService.updateCustomer(request, id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<GeneralMessage> deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new GeneralMessage("Customer successfully deleted"));
	}
}