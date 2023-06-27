package com.hackacode.marveland.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "EMPLOYEES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "DNI")
    private Integer dni;

    @Column(name = "EMAIL")
    private String email;

    @UpdateTimestamp
    @Column(name = "REGISTRATION_DATE")
    private LocalDateTime registrationDate;

    @Column(name = "WORKING_HOURS")
    private String workingHours;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    private User user;
}
