package com.hackacode.marveland.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameEmployeeResponseDto {

	private Long id;

	private String firstName;

	private String lastName;
}
