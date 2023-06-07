package com.hackacode.marveland.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackacode.marveland.model.entity.User;

public interface IUserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByUsername(String username);
}