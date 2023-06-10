package com.hackacode.marveland.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@Column(name = "id", nullable = false)
	private Long id;

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