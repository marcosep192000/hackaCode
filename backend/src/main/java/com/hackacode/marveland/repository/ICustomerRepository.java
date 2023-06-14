package com.hackacode.marveland.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackacode.marveland.model.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

	public Customer findByDni(int dni);
}