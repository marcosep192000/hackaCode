package com.hackacode.marveland.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TICKET")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TICKET_ID", nullable = false)
    private Long id;

    @Column(name = "EXPIRATION_DATE")
    private Date expirationDate;

    @ManyToOne
    @JoinColumn(name = "GAME_ID", referencedColumnName = "GAME_ID")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "PURCHASE_DETAILS_ID", referencedColumnName = "PURCHASE_ID")
    private PurchaseDetails purchaseDetails;

}
