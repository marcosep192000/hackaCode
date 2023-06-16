package com.hackacode.marveland.model.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminEmployeeResponseDto {

	private Long id;

	private String firstName;

	private String lastName;

	private Integer dni;

	private String email;

	private LocalDateTime updateDate;

	private String workingHours;

	private List<CustomerListResponseDto> customers;
}
