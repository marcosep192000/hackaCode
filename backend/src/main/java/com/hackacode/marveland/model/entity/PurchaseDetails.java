package com.hackacode.marveland.model.entity;

import java.time.LocalDate;
import java.util.List;

import com.hackacode.marveland.util.enums.PaymentMethod;

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

@Entity
@Table(name = "PURCHASES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PURCHASE_DETAILS_ID")
    private Long id;

    @Column(name = "DETAILS")
    private String details;

    @Column(name = "PURCHASE_DATE")
    private LocalDate purchaseDate;

    @OneToMany(mappedBy = "purchaseDetails")
    private List<Ticket> tickets;

    @Column(name = "PAYMENT_METHOD")
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID", insertable = false, updatable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "GAME_EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID", insertable = false, updatable = false)
    private GameEmployee gameEmployee;
}