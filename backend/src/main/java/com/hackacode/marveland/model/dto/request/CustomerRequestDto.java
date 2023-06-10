package com.hackacode.marveland.model.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

	@NotBlank(message = "this field can not be blank")
	@Column(name = "dni")
	private  int dni;

	@NotBlank(message = "this field can not be blank")
	@Column(name = "EMAIL")
	private String email;

	@NotBlank(message = "this field can not be blank")
	@Column(name = "BIRTH_DATE")
	private String birthDate;
}
