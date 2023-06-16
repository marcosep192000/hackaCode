package com.hackacode.marveland.model.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetailsResponseDto {

    private Long id;

    private String firstName;

    private String lastName;

    private Integer dni;

    private String email;

    private LocalDateTime registrationDate;

    private String workingHours;
}