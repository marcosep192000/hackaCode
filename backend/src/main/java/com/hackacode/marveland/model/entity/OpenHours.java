package com.hackacode.marveland.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OPEN_HOURS")
public class OpenHours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPEN_HOURS_ID")
    private Long id;

    @Column(name = "START_TIME")
    @Temporal(TemporalType.TIME)
    private Date startTime;

    @Column(name = "END_TIME")
    @Temporal(TemporalType.TIME)
    private Date endTime;

    @OneToMany
    private List<Game> games;
}