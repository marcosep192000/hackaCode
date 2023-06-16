package com.hackacode.marveland.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackacode.marveland.model.dto.request.AuthRequestDto;
import com.hackacode.marveland.model.dto.request.RegisterRequestDto;
import com.hackacode.marveland.model.dto.response.AuthResponseDto;
import com.hackacode.marveland.service.IAuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

        private final IAuthService authService;

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
}