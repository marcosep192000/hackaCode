package com.hackacode.marveland.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameEmployeeRequestDto {

	private String firstName;

    private String lastName;

    private int dni;

    private String email;

	private String password;

	// "18:00 a 22:00"
    private String workingHours;
}
