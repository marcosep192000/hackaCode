package com.hackacode.marveland.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackacode.marveland.model.dto.request.AdminEmployeeRequestDto;
import com.hackacode.marveland.service.IAdminEmployeeService;
import com.hackacode.marveland.util.Exeptions.GeneralMessage;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminEmployeeController {

	private final IAdminEmployeeService adminEmployeeService;

	// devuelve todos los admin mas sus clientes
	@GetMapping("/all-admin-customer")
	public ResponseEntity<?> ListCustomer() {
		return ResponseEntity.status(HttpStatus.OK).body(adminEmployeeService.getAllAdminCustomer());
	}

	@GetMapping("/all-admin")
	public ResponseEntity<?> listAdmin() {
		return ResponseEntity.status(HttpStatus.OK).body(adminEmployeeService.getAllAdmin());
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> findByDni(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(adminEmployeeService.getById(id));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@Valid @PathVariable Long id, @RequestBody AdminEmployeeRequestDto requestDto) {
		adminEmployeeService.update(requestDto, id);
		return ResponseEntity.status(HttpStatus.OK).body(new GeneralMessage("Admin Updated"));
	}
}
