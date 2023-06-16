package com.hackacode.marveland.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hackacode.marveland.model.dto.request.AdminEmployeeRequestDto;
import com.hackacode.marveland.service.IEmployeeService;
import com.hackacode.marveland.util.exceptions.GeneralMessage;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

	private final IEmployeeService adminEmployeeService;

	// getmapping --> traer lista de empleados por filtro: rol, horario de trabajo, etc
	// Ej: Lista de empleados encargados de juegos con su juego asignado.
	// postmapping --> asignar juego a un empleado

	// devuelve todos los admin mas sus clientes
	@GetMapping("/all-admin-customer")
	public ResponseEntity<?> ListCustomer() {
		return ResponseEntity.status(HttpStatus.OK).body(adminEmployeeService.getAllAdminCustomer());
	}

	@GetMapping("/all")
	public ResponseEntity<?> listAdmin() {
		return ResponseEntity.status(HttpStatus.OK).body(adminEmployeeService.getAllAdmin());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findByDni(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(adminEmployeeService.getById(id));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@Valid @PathVariable Long id, @RequestBody AdminEmployeeRequestDto requestDto) {
		adminEmployeeService.update(requestDto, id);
		return ResponseEntity.status(HttpStatus.OK).body(new GeneralMessage("Admin Updated"));
	}
}
