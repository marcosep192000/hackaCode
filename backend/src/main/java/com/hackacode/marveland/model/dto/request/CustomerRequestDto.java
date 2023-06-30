package com.hackacode.marveland.model.dto.request;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class CustomerRequestDto implements Serializable {

	@NotBlank(message = "First name cannot be blank")
	private String firstName;

	@NotBlank(message = "Last name cannot be blank")
	private String lastName;

	@NotNull(message = "DNI cannot be null")
	private Integer dni;

	@NotBlank(message = "Email cannot be blank")
	private String email;

	@NotBlank(message = "Phone cannot be blank")
	private String phone;

	@NotBlank(message = "Birthdate cannot be blank")
	private LocalDate birthdate;
}
