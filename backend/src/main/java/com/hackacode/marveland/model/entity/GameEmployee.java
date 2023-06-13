package com.hackacode.marveland.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "game_employee")
public class GameEmployee extends Person {

    @OneToOne(mappedBy = "gameEmployee")
    private Game game;

    @OneToMany(mappedBy = "gameEmployee")
    private List<PurchaseDetails> salesList;
}