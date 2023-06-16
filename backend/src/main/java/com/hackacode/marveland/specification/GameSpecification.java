package com.hackacode.marveland.specification;

import org.springframework.data.jpa.domain.Specification;

import com.hackacode.marveland.model.entity.Game;

public class GameSpecification {

    public static Specification<Game> hasName(String name) {
        return (root, query, cb) -> cb.equal(root.get("name"), name);
    }

    public static Specification<Game> hasCapacity(Integer capacity) {
        return (root, query, cb) -> cb.equal(root.get("capacity"), capacity);
    }

    public static Specification<Game> hasPrice(Double price) {
        return (root, query, cb) -> cb.equal(root.get("price"), price);
    }
}
