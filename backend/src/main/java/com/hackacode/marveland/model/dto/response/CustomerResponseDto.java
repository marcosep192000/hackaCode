package com.hackacode.marveland.model.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponseDto {

	private Long id;

	private String firstName;

	private String lastName;

	private Integer dni;

	private String email;

	private String phone;

	private LocalDate birthdate;

	private LocalDateTime registrationDate;
}
