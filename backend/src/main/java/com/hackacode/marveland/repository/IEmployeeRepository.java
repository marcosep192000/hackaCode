package com.hackacode.marveland.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackacode.marveland.model.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

}