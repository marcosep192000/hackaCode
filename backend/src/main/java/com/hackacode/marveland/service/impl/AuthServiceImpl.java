package com.hackacode.marveland.service.impl;

import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hackacode.marveland.config.jwt.JwtProvider;
import com.hackacode.marveland.model.dto.request.AuthRequestDto;
import com.hackacode.marveland.model.dto.request.RegisterRequestDto;
import com.hackacode.marveland.model.dto.response.AuthResponseDto;
import com.hackacode.marveland.model.entity.Employee;
import com.hackacode.marveland.model.entity.User;
import com.hackacode.marveland.repository.IEmployeeRepository;
import com.hackacode.marveland.repository.IUserRepository;
import com.hackacode.marveland.service.IAuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

        private final IUserRepository userRepository;

        private final IEmployeeRepository employeeRepository;

        private final PasswordEncoder passwordEncoder;

        private final JwtProvider jwtProvider;

        private final AuthenticationManager authenticationManager;

        @Override
        public AuthResponseDto register(RegisterRequestDto request) {

                Optional<User> userOptional = userRepository.findByUsername(request.getUsername());
                if (userOptional.isPresent()) {
                        throw new RuntimeException("Username already in use");
                }

                User user = User.builder()
                                .username(request.getUsername())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .role(request.getRole())
                                .build();

                Employee employee = Employee.builder()
                                .firstName(request.getFirstName())
                                .lastName(request.getLastName())
                                .build();
                employee.setUser(user);

                userRepository.save(user);
                employeeRepository.save(employee);

                String jwt = jwtProvider.generateToken(user);

                return AuthResponseDto.builder()
                                .userId(user.getId())
                                .role(user.getRole())
                                .token(jwt)
                                .build();
        }

        @Override
        public AuthResponseDto login(AuthRequestDto request) {

                try {
                        authenticationManager
                                        .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),
                                                        request.getPassword()));
                } catch (AuthenticationException e) {
                        throw new BadCredentialsException("Incorrect username or password", e);
                }

                User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
                String jwt = jwtProvider.generateToken(user);

                return AuthResponseDto.builder()
                                .userId(user.getId())
                                .role(user.getRole())
                                .token(jwt)
                                .build();
        }
}