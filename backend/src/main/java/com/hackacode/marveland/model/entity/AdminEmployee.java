package com.hackacode.marveland.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ADMIN_EMPLOYEE")
public class AdminEmployee extends Person {

}