package com.hackacode.marveland.model.entity;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "OPEN_HOURS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OpenHours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPEN_HOURS_ID")
    private Long id;

    @Column(name = "START_TIME", columnDefinition = "TIME")
    private LocalTime startTime;

    @Column(name = "END_TIME", columnDefinition = "TIME")
    private LocalTime endTime;
}