package com.hackacode.marveland.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackacode.marveland.model.entity.AdminEmployee;

public interface IAdminEmployeeRepository extends JpaRepository<AdminEmployee, Long> {

    public AdminEmployee findByEmail(String email);
}