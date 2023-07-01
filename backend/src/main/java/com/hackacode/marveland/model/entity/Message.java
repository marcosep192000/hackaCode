package com.hackacode.marveland.model.entity;

import java.time.LocalDate;

import com.hackacode.marveland.model.dto.request.CustomerRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "MESSAGES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MESSAGE_ID")
    private Long id;

    @Column(name = "MESSAGE_DATE")
    private LocalDate messageDate;

    @Column(name = "EMPLOYEE_FULL_NAME")
    private String employeeFullName;

    @Column(name = "DETAILS")
    private String details;

    @Column(name = "CUSTOMER_REQUEST")
    private CustomerRequestDto customerRequest;
}
