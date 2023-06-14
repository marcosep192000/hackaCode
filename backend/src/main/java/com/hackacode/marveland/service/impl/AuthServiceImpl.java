package com.hackacode.marveland.service.impl;

import java.time.LocalDateTime;
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
import com.hackacode.marveland.model.entity.AdminEmployee;
import com.hackacode.marveland.model.entity.GameEmployee;
import com.hackacode.marveland.model.entity.User;
import com.hackacode.marveland.repository.IAdminEmployeeRepository;
import com.hackacode.marveland.repository.IGameEmployeeRepository;
import com.hackacode.marveland.repository.IUserRepository;
import com.hackacode.marveland.service.IAuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

        private final IUserRepository userRepository;

        private final PasswordEncoder passwordEncoder;

        private final JwtProvider jwtProvider;

        private final AuthenticationManager authenticationManager;

        private final IGameEmployeeRepository gameEmployeeRepository;

        private final IAdminEmployeeRepository adminEmployeeRepository;

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

                if (user.getRole().contains("ADMIN")) {
                        AdminEmployee adminEmployee = new AdminEmployee();
                        adminEmployee.setFirstName(request.getFirstName());
                        adminEmployee.setLastName(request.getLastName());
                        adminEmployee.setDni(request.getDni());
                        adminEmployee.setEmail(request.getUsername());
                        adminEmployee.setUpdateDate(LocalDateTime.now());
                        adminEmployee.setWorkingHours(request.getWorkingHours());
                        adminEmployee.setUser(user);
                        userRepository.save(user);
                        adminEmployeeRepository.save(adminEmployee);

                } else if (user.getRole().contains("EMPLOYEE")) {
                        GameEmployee gameEmployee = new GameEmployee();
                        gameEmployee.setFirstName(request.getFirstName());
                        gameEmployee.setLastName(request.getLastName());
                        gameEmployee.setDni(request.getDni());
                        gameEmployee.setEmail(request.getUsername());
                        gameEmployee.setUpdateDate(LocalDateTime.now());
                        gameEmployee.setWorkingHours(request.getWorkingHours());
                        gameEmployee.setUser(user);
                        userRepository.save(user);
                        gameEmployeeRepository.save(gameEmployee);
                }

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
                        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                                        request.getUsername(), request.getPassword()));
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