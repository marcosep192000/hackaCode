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
@Table(name = "PURCHASE")
public class PurchaseDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PURCHASE_ID")
    private Long id;

    @Column(name = "DETAILS")
    private String details;

    @Column(name = "DATE")
    private Date date;

    @ManyToOne
    private Customer customer;

    @OneToMany
    private List<Ticket> ticketList;
}