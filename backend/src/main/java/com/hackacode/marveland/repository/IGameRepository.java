package com.hackacode.marveland.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackacode.marveland.model.entity.Game;

public interface IGameRepository extends JpaRepository<Game, Long> {

}