package com.hackacode.marveland.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ADMIN_EMPLOYEE")
public class AdminEmployee extends Person {
@OneToMany
List<Customer> listCustomer = new ArrayList<>();
}