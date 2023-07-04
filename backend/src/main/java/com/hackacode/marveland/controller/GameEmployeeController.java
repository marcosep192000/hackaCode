package com.hackacode.marveland.controller;

import com.hackacode.marveland.config.jwt.JwtProvider;

import com.hackacode.marveland.model.dto.request.GameEmployeeRequestDto;

import com.hackacode.marveland.model.dto.response.GameEmployeeResponseDto;
import com.hackacode.marveland.model.entity.GameEmployee;
import com.hackacode.marveland.service.IGameEmployeeService;
import com.hackacode.marveland.util.exceptions.GeneralMessage;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/game-employee")
@CrossOrigin(origins = "*")
@Tag(name = "Game Employee", description = "Management of Game emplyee  in Marveland. It allows creating, modifying, and deleting gameEplyee, as well as obtaining detailed information about them.")
@SecurityRequirement(name = "bearerAuth")
@RequiredArgsConstructor
public class GameEmployeeController {

	private final IGameEmployeeService gameEmployeeService;
	private final JwtProvider jwtProvider;
	@GetMapping("/all")
	public ResponseEntity<List<GameEmployeeResponseDto>> getAll(){
		List<GameEmployeeResponseDto> response = gameEmployeeService.getAll();
		return ResponseEntity.ok(response);
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<GameEmployee>> all(){
	     List<GameEmployee> gameEmployee = gameEmployeeService.All();
		return ResponseEntity.ok(gameEmployee);
	}
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestHeader("Authorization") String token,
													  @RequestBody GameEmployeeRequestDto request) {
		String email = jwtProvider.extractUsername(token.substring(7));
	GameEmployeeResponseDto response = gameEmployeeService.create(request, email);
		return ResponseEntity.status(HttpStatus.CREATED).body("creado");
	}
//
//	@PutMapping("/update/{id}")
//	public ResponseEntity<CustomerResponseDto> update(@PathVariable Long id,
//													  @RequestBody CustomerRequestDto request) {
//		CustomerResponseDto response = customerService.update(request, id);
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
//	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		gameEmployeeService.delete(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new GeneralMessage("Customer successfully deleted"));
	}
}
