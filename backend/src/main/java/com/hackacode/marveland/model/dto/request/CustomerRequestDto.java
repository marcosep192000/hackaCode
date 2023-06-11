package com.hackacode.marveland.model.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDto {

	@NotBlank(message = "this field can not be blank")
	@Column(name = "FIRST_NAME")
	private String firstName;

	@NotBlank(message = "this field can not be blank")
	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "dni")
	private  int dni;

	@Email(message = "incorrect format")
	@NotBlank(message = "this field can not be blank")
	@Column(name = "EMAIL")
	private String email;

	@NotBlank(message = "this field can not be blank")
	@Column(name = "BIRTH_DATE")
	private String birthDate;
}
