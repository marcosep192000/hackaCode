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
import com.hackacode.marveland.model.entity.Person;
import com.hackacode.marveland.model.entity.User;
import com.hackacode.marveland.repository.IPersonRepository;
import com.hackacode.marveland.repository.IUserRepository;
import com.hackacode.marveland.service.IAuthService;
import com.hackacode.marveland.util.enums.Role;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

        private final IUserRepository userRepository;

        private final IPersonRepository personRepository;

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
                                .role(Role.USER.name())
                                .build();

                Person person = Person.builder()
                                .firstName(request.getFirstName())
                                .lastName(request.getLastName())
                                .build();

                user.setPerson(person);

                userRepository.save(user);
                personRepository.save(person);

                var jwt = jwtProvider.generateToken(user);

                // String to = request.getUsername();
                // String subject = "Acceso al Campus Virtual";
                // String text = "<html><body>"
                //                 + "<p>Estimado/a estudiante,</p>"
                //                 + "<p>Le informamos que ya cuenta con acceso al Campus Virtual.</p>"
                //                 + "<p>A continuación, encontrará los detalles de inicio de sesión:</p>"
                //                 + "<ul>"
                //                 + "<li>Nombre de usuario: " + request.getUsername() + "</li>"
                //                 + "<li>Contraseña: " + request.getPassword() + "</li>"
                //                 + "</ul>"
                //                 + "<p>Para acceder a su cuenta, por favor visite nuestro sitio web en <a href=\"https://bright-english.vercel.app/\">bright-english.vercel.app</a>.</p>"
                //                 + "<p>Atentamente,<br>Bright English</p>"
                //                 + "</body></html>";

                // try {
                //         mailSender.sendEmail(to, subject, text);
                // } catch (MessagingException e) {
                //         e.printStackTrace();
                // }

                return AuthResponseDto.builder()
                                .id(person.getId())
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

                var user = userRepository.findByUsername(request.getUsername()).orElseThrow();
                var jwt = jwtProvider.generateToken(user);

                return AuthResponseDto.builder()
                                .id(user.getPerson().getId())
                                .role(user.getRole())
                                .token(jwt)
                                .build();
        }
}