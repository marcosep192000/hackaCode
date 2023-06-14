package com.hackacode.marveland.model.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ADMIN_EMPLOYEE")
public class AdminEmployee extends Employee {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "adminEmployee")
	@JsonIgnoreProperties("adminEmployee")
	private List<Customer> customerList = new ArrayList<>();
}