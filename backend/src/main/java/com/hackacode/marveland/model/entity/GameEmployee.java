package com.hackacode.marveland.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "GAME_EMPLOYEES")
public class GameEmployee extends Employee {

    @OneToMany(mappedBy = "gameEmployee")
    private List<Game> games;

    @OneToMany(mappedBy = "gameEmployee")
    private List<PurchaseDetails> salesList;
}