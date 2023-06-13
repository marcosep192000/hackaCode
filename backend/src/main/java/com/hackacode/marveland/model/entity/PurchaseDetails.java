package com.hackacode.marveland.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hackacode.marveland.controller.CustomerController;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static jakarta.persistence.FetchType.EAGER;

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

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    Customer customer ;

   @ManyToOne()
   @JoinColumn(name = "gameEmployee_id")
   private  GameEmployee gameEmployee;

    @OneToMany
    private List<Ticket> ticketList =new ArrayList<>();

}