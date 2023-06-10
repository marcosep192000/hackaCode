package com.hackacode.marveland.repository;

import com.hackacode.marveland.model.entity.GameEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameEmployeeRepository extends JpaRepository<GameEmployee, Long> {
}