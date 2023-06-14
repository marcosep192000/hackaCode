package com.hackacode.marveland.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackacode.marveland.model.dto.request.CustomerRequestDto;
import com.hackacode.marveland.model.dto.response.CustomerResponseDto;
import com.hackacode.marveland.service.ICustomerService;
import com.hackacode.marveland.util.Exeptions.GeneralMessage;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

	private final ICustomerService customerService;

	@PostMapping("/create/{id}")
	public ResponseEntity<?> create(@Valid @RequestBody CustomerRequestDto customerRequestDto, @PathVariable Long id) {
		customerService.create(customerRequestDto, id);
		return ResponseEntity.status(HttpStatus.CREATED).body(new GeneralMessage("Customer created!"));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(customerService.getById(id));
	}

	@GetMapping("/dni/{dni}")
	public ResponseEntity<?> findByDni(@PathVariable Integer dni) {
		return ResponseEntity.status(HttpStatus.OK).body(customerService.getByDni(dni));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<CustomerResponseDto> update(@Valid @PathVariable Long id,
			@RequestBody CustomerRequestDto requestDto) {
		CustomerResponseDto customer = customerService.update(requestDto, id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(customer);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		customerService.delete(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new GeneralMessage("Customer Deleted"));
	}
}
