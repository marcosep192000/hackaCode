package com.hackacode.marveland.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackacode.marveland.model.entity.Person;

public interface IPersonRepository extends JpaRepository<Person, Long> {

}