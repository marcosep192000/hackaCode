package com.hackacode.marveland.model.entity;

import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "GAMES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GAME_ID", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "game")
    private List<GameEmployee> gameEmployees;

    @Column(name = "NAME")
    private String name;

  //@OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
   // private List<OpenHours> openHours;

    @Column(name = "CAPACITY")
    private Integer capacity;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "START_TIME", columnDefinition = "TIME")
    private LocalTime startTime;

    @Column(name = "END_TIME", columnDefinition = "TIME")
    private LocalTime endTime;

    @JsonIgnore
    @OneToMany(mappedBy = "game")
    private List<TiketB> tickets;
}
