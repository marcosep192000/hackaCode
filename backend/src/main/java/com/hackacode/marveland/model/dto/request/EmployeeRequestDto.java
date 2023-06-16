package com.hackacode.marveland.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDto {

	@NotBlank(message = "First name cannot be blank")
	private String firstName;

	@NotBlank(message = "Last name cannot be blank")
	private String lastName;

	@NotNull(message = "DNI cannot be null")
	private Integer dni;

	@NotBlank(message = "Email cannot be blank")
	private String email;

	@NotBlank(message = "Working hours cannot be blank")
	private String workingHours;
}
