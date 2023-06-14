package com.hackacode.marveland.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminEmployeeRequestDto {

	private String firstName;

	private String lastName;

	private int dni;

	private String email;
}
