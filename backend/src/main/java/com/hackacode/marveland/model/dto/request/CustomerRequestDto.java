package com.hackacode.marveland.model.dto.request;

import java.io.Serializable;

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

	private String firstName;

	private String lastName;

	private Integer dni;

	private String email;

	private String phone;

	private String birthdate;
}
