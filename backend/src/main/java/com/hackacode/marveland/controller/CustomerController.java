package com.hackacode.marveland.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hackacode.marveland.config.jwt.JwtProvider;
import com.hackacode.marveland.model.dto.request.CustomerRequestDto;
import com.hackacode.marveland.model.dto.response.CustomerResponseDto;
import com.hackacode.marveland.service.ICustomerService;
import com.hackacode.marveland.util.exceptions.GeneralMessage;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class CustomerController {

	private final ICustomerService customerService;

	private final JwtProvider jwtProvider;

	@GetMapping("/filters")
	public ResponseEntity<List<CustomerResponseDto>> getByFilters() {
		List<CustomerResponseDto> response = customerService.getByFilters();
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerResponseDto> getById(@PathVariable Long id) {
		CustomerResponseDto response = customerService.getById(id);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<CustomerResponseDto>> getAll(){
		List<CustomerResponseDto> response = customerService.getAll();
		return ResponseEntity.ok(response);
	}

	@PostMapping("/create")
	public ResponseEntity<CustomerResponseDto> create(@RequestHeader("Authorization") String token,
                                                      @RequestBody CustomerRequestDto request) {
		String email = jwtProvider.extractUsername(token.substring(7));
		CustomerResponseDto response = customerService.create(request, email);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<CustomerResponseDto> update(@PathVariable Long id,
                                                      @RequestBody CustomerRequestDto request) {
		CustomerResponseDto response = customerService.update(request, id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}

	@GetMapping("/findByBirthdate")
	public ResponseEntity<List<CustomerResponseDto>> findByBirthdate(){
		List<CustomerResponseDto> response = customerService.findByBirthdate();
		return ResponseEntity.ok(response);
	}

	@PostMapping("/sendCouponEmail")
	public void sendCouponEmail(){
		customerService.sendCouponEmail();
	}

	@GetMapping("/morePurchasesByYear")
	public ResponseEntity<CustomerResponseDto> morePurchasesByYear(@RequestParam int year){
		CustomerResponseDto response = customerService.morePurchasesByYear(year);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/morePurchasesByMonth")
	public ResponseEntity<CustomerResponseDto> morePurchasesByMonth(@RequestParam int month, @RequestParam int year){
		CustomerResponseDto response = customerService.morePurchasesByMonth(month, year);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<GeneralMessage> delete(@PathVariable Long id) {
		customerService.delete(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new GeneralMessage("Customer successfully deleted"));
	}
}