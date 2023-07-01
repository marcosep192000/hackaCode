package com.hackacode.marveland.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "GAME_EMPLOYEES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameEmployee extends Employee {

    @OneToOne
    @JoinColumn(name = "ASSIGNED_GAME_ID", referencedColumnName = "GAME_ID")
    private Game game;

    @OneToMany(mappedBy = "gameEmployee")
    private List<PurchaseDetails> salesList;
}