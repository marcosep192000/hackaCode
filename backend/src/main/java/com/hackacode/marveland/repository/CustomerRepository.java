package com.hackacode.marveland.repository;

import com.hackacode.marveland.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Customer findByDni(int dni);
}