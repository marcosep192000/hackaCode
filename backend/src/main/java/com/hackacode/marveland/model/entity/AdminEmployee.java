package com.hackacode.marveland.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "ADMIN_EMPLOYEES")
@Getter
@Setter



@AllArgsConstructor
@NoArgsConstructor
public class AdminEmployee extends Employee {

	@OneToMany(mappedBy = "adminEmployee")
	private List<Customer> customers;
	@OneToMany(mappedBy = "adminEmployee")
	private List<GameEmployee> gameEmployees;


}