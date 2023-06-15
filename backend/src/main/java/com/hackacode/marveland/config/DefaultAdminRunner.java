package com.hackacode.marveland.config;

import java.time.LocalDateTime;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.hackacode.marveland.model.entity.AdminEmployee;
import com.hackacode.marveland.model.entity.User;
import com.hackacode.marveland.repository.IAdminEmployeeRepository;
import com.hackacode.marveland.repository.IUserRepository;

import lombok.RequiredArgsConstructor;

@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE)
@RequiredArgsConstructor
public class DefaultAdminRunner implements ApplicationRunner {

    private final IUserRepository userRepository;

    private final IAdminEmployeeRepository adminEmployeeRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = User.builder()
                .username("lionelmessi@gmail.com")
                .password(passwordEncoder.encode("1234"))
                .role("ADMIN")
                .build();

        AdminEmployee adminEmployee = new AdminEmployee();
        adminEmployee.setFirstName("Lionel");
        adminEmployee.setLastName("Messi");
        adminEmployee.setDni(12345678);
        adminEmployee.setEmail("lionelmessi@gmail.com");
        adminEmployee.setUpdateDate(LocalDateTime.now());
        adminEmployee.setWorkingHours("10:00 a 18:00");
        adminEmployee.setUser(user);
        
        userRepository.save(user);
        adminEmployeeRepository.save(adminEmployee);

        if (!userRepository.findByUsername(user.getUsername()).isPresent()) {
            userRepository.save(user);
            adminEmployeeRepository.save(adminEmployee);
        }
    }
}