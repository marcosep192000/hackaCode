package com.hackacode.marveland.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "GAME_EMPLOYEES")
public class GameEmployee extends Employee {

    @ManyToOne
    @JoinColumn(name = "ASSIGNED_GAME_ID", referencedColumnName = "GAME_ID")
    private Game game;

    @OneToMany(mappedBy = "gameEmployee")
    private List<PurchaseDetails> salesList;
}