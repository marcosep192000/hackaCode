package com.hackacode.marveland.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDto {

	private String firstName;

	private String lastName;

	private int dni;

	private String email;

	private String birthDate;

	private String phone;
}
