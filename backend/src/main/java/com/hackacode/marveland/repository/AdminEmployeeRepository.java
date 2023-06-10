package com.hackacode.marveland.repository;

import com.hackacode.marveland.model.entity.AdminEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminEmployeeRepository extends JpaRepository<AdminEmployee, Long> {
}