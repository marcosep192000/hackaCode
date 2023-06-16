package com.hackacode.marveland.controller;

import java.util.List;

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
import com.hackacode.marveland.model.dto.response.EmployeeListResponseDto;
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
	public ResponseEntity<List<EmployeeListResponseDto>> getEmployeesByFilters() {
		List<EmployeeListResponseDto> response = employeeService.getEmployeesByFilters();
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeListResponseDto> getEmployeeById(@PathVariable Long id) {
		EmployeeListResponseDto response = employeeService.getEmployeeById(id);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeListResponseDto> updateEmployee(@PathVariable Long id,
			@RequestBody EmployeeRequestDto request) {
		EmployeeListResponseDto response = employeeService.updateEmployee(request, id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<GeneralMessage> deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new GeneralMessage("Employee successfully deleted"));
	}
}