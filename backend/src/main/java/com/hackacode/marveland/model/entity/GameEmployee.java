package com.hackacode.marveland.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "game_employee")
public class GameEmployee extends Person {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gameEmployee" )
	List<PurchaseDetails> purchaseDetailsList = new ArrayList<>();


}