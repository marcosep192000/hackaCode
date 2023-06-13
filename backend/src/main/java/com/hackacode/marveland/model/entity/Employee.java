package com.hackacode.marveland.model.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
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
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "EMPLOYEES")
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
    private int dni;

    @Column(name = "EMAIL")
    private String email;

    @UpdateTimestamp
    @Column(name = "updated_on_date")
    private LocalDateTime updateDate;

    @Column(name = "WORKING_HOURS")
    private String workingHours;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_FK", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    private User user;
}
