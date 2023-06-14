package com.hackacode.marveland.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackacode.marveland.model.entity.OpenHours;

public interface IOpenHoursRepository extends JpaRepository<OpenHours, Long> {

}