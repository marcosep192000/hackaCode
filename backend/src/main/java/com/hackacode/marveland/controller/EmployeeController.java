package com.hackacode.marveland.controller;

import java.util.List;

import com.hackacode.marveland.config.jwt.JwtProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackacode.marveland.model.dto.request.EmployeeRequestDto;
import com.hackacode.marveland.model.dto.request.MessageRequestDto;
import com.hackacode.marveland.model.dto.response.EmployeeResponseDto;
import com.hackacode.marveland.model.entity.Message;
import com.hackacode.marveland.service.IEmployeeService;
import com.hackacode.marveland.util.exceptions.GeneralMessage;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/employees")
@Tag(name = "Employees", description = "Management of employees in Marveland. It allows modifying and deleting employees, as well as obtaining detailed information about them.")
@SecurityRequirement(name = "bearerAuth")
@RequiredArgsConstructor
public class EmployeeController {

	private final IEmployeeService employeeService;
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

	@GetMapping("/role")
	public ResponseEntity<String> getRoleByToken(@RequestHeader("Authorization") String token) {
		String response = employeeService.getRoleByToken(token);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeResponseDto> update(@PathVariable Long id,
			@RequestBody EmployeeRequestDto request) {
		EmployeeResponseDto response = employeeService.update(request, id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		employeeService.delete(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new GeneralMessage("Employee successfully deleted"));
	}

	// admin employees: get all requests
	@GetMapping("/messages")
	public ResponseEntity<List<Message>> getMessages() {
		List<Message> response = employeeService.getMessages();
		return ResponseEntity.ok(response);
	}

	// game employees: request new customer
	@PostMapping("/request/{id}")
	public ResponseEntity<GeneralMessage> requestToAdmin(@PathVariable Long id, @RequestBody MessageRequestDto request) {
		employeeService.requestToAdmin(request, id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new GeneralMessage("Request sent"));
	}
}