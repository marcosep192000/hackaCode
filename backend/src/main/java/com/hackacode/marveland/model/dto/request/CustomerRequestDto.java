package com.hackacode.marveland.model.dto.request;

import java.io.Serializable;

import jakarta.persistence.Column;
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

	@NotNull(message = "this field can not be blank")
	private String firstName;
	@NotBlank(message = "this field can not be blank")
	private String lastName;
	private Integer dni;
	@NotBlank(message = "this field can not be blank")
	private String email;
	@NotBlank(message = "this field can not be blank")
	private String phone;
	@NotBlank(message = "this field can not be blank")
	private String birthdate;
}
