package com.hackacode.marveland.repository;

import com.hackacode.marveland.model.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGameRepository extends JpaRepository<Game, Long> {
}