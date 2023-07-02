package com.hackacode.marveland.model.entity;

import java.util.List;

import jakarta.persistence.*;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_game")
    private  Game game;

    @OneToMany(mappedBy = "gameEmployee")
    private List<PurchaseDetails> salesList;
}