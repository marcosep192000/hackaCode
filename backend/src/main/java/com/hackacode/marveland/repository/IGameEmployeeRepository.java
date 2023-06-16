package com.hackacode.marveland.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackacode.marveland.model.entity.GameEmployee;

public interface IGameEmployeeRepository extends JpaRepository<GameEmployee, Long> {

}