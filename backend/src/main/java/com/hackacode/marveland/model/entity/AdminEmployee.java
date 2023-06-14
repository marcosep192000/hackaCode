package com.hackacode.marveland.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ADMIN_EMPLOYEES")
public class AdminEmployee extends Employee {

	@OneToMany(mappedBy = "adminEmployee")
	private List<Customer> customerList;
}