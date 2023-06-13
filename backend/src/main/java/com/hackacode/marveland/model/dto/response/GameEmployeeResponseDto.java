package com.hackacode.marveland.model.dto.response;

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
public class GameEmployeeResponseDto {
	@Column(name = "EMPLOYEE_ID")
	private Long id;

	@NotBlank(message = "this field can not be blank")
	@Column(name = "FIRST_NAME")
	private String firstName;

	@NotBlank(message = "this field can not be blank")
	@Column(name = "LAST_NAME")
	private String lastName;
}
