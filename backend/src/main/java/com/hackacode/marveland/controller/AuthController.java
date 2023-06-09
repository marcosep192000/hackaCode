package com.hackacode.marveland.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
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
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequestDto request) {
            AuthResponseDto response = authService.register(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody AuthRequestDto request) {
            AuthResponseDto response = authService.login(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}