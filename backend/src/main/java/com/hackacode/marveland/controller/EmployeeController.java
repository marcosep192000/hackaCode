package com.hackacode.marveland.controller;

import java.util.List;

import com.hackacode.marveland.model.dto.response.EmployeeResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackacode.marveland.model.dto.request.EmployeeRequestDto;
import com.hackacode.marveland.service.IEmployeeService;
import com.hackacode.marveland.util.exceptions.GeneralMessage;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/employees")

@RequiredArgsConstructor
public class EmployeeController {

	private final IEmployeeService employeeService;

	@GetMapping("/filters")
	public ResponseEntity<List<EmployeeResponseDto>> getByFilters() {
		List<EmployeeResponseDto> response = employeeService.getByFilters();
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponseDto> getById(@PathVariable Long id) {
		EmployeeResponseDto response = employeeService.getById(id);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<EmployeeResponseDto>> getAll(){
		List<EmployeeResponseDto> response = employeeService.getAll();
		return ResponseEntity.ok(response);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeResponseDto> update(@PathVariable Long id,
			@RequestBody EmployeeRequestDto request) {
		EmployeeResponseDto response = employeeService.update(request, id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<GeneralMessage> delete(@PathVariable Long id) {
		employeeService.delete(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new GeneralMessage("Employee successfully deleted"));
	}
}