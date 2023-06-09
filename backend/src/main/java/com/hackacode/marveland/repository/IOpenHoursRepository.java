package com.hackacode.marveland.repository;

import com.hackacode.marveland.model.entity.OpenHours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOpenHoursRepository extends JpaRepository<OpenHours, Long> {
}