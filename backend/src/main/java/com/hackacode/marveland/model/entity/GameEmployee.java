package com.hackacode.marveland.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "GAME_EMPLOYEES")
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class GameEmployee extends Employee {

//    @OneToMany(mappedBy = "gameEmployee")
//    private List<PurchaseDetails> salesList;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name ="game_id")
    private Game game;
    private long games;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ADMIN_EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID", insertable = false, updatable = false)
    private AdminEmployee adminEmployee;


}