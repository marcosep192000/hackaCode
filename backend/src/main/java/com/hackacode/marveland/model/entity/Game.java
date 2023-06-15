package com.hackacode.marveland.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "GAMES")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GAME_ID", nullable = false)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "OPEN_HOURS_ID", referencedColumnName = "OPEN_HOURS_ID")
    private OpenHours openHours;

    @Column(name = "CAPACITY")
    private Integer capacity;

    @Column(name = "PRICE")
    private Double price;

    @OneToMany(mappedBy = "game")
    private List<GameEmployee> employees;

    @OneToMany(mappedBy = "game")
    private List<Ticket> tickets;
}
