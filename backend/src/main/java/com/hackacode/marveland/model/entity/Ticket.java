package com.hackacode.marveland.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "TICKETS")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TICKET_ID", nullable = false)
    private Long id;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "DNI")
    private Integer dni;

    @Column(name = "EXPIRATION_DATE")
    private LocalDate expirationDate;

    @ManyToOne
    @JoinColumn(name = "GAME_ID", referencedColumnName = "GAME_ID", insertable = false, updatable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "PURCHASE_DETAILS_ID", referencedColumnName = "PURCHASE_DETAILS_ID", insertable = false, updatable = false)
    private PurchaseDetails purchaseDetails;

    @Column(name = "FULL_NAME")
    private String name;

    @Column(name = "DNI")
    private Long dni;
}
