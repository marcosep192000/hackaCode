package com.hackacode.marveland.controller;

import com.hackacode.marveland.model.entity.User;
import com.hackacode.marveland.repository.IUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hackacode.marveland.model.dto.request.AuthRequestDto;
import com.hackacode.marveland.model.dto.request.RegisterRequestDto;
import com.hackacode.marveland.model.dto.response.AuthResponseDto;
import com.hackacode.marveland.service.IAuthService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*")
@Tag(name = "Authentication", description = "Registration and login for Marveland employees.")
@RequiredArgsConstructor
public class AuthController {

        private final IAuthService authService;
      IUserRepository repository;
        @PostMapping("/register")
        public ResponseEntity<AuthResponseDto> register(@RequestBody RegisterRequestDto request) {
                AuthResponseDto response = authService.register(request);
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        @PostMapping("/login")
        public ResponseEntity<AuthResponseDto> login(@RequestBody AuthRequestDto request) {
                AuthResponseDto response = authService.login(request);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        }
        @GetMapping("/all")
        public ResponseEntity<List<User>> all() {
              List<User> response = repository.findAll() ;
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        }



}