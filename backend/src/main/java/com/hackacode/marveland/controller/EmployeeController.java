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
import com.hackacode.marveland.service.IEmployeeService;
import com.hackacode.marveland.util.exceptions.GeneralMessage;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

	private final IEmployeeService employeeService;

	// getmapping --> traer lista de empleados por filtro: rol, horario de trabajo,
	// etc
	// Ej: Lista de empleados encargados
	// getmapping --> traer lista de empleados por filtro: rol, horario de trabajo,
	// etc
	// Ej: Lista de empleados encargados de juegos con su juego asignado.
	// postmapping --> asignar juego a un empleado de juegos con su juego asignado.
	// postmapping --> asignar juego a un empleado

	@GetMapping("/all")
	public ResponseEntity<?> getAllEmployees() {
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployees());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeById(id));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateEmployee(@Valid @PathVariable Long id,
			@RequestBody AdminEmployeeRequestDto requestDto) {
		employeeService.updateEmployee(requestDto, id);
		return ResponseEntity.status(HttpStatus.OK).body(new GeneralMessage("Employee Updated"));
	}
}
