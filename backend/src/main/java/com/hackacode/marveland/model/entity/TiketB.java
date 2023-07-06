package com.hackacode.marveland.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class TiketB {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false)
	private Long id;


	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;


	

	@ManyToOne
	@JoinColumn(name = "juego_id")
	private Game game;
	private LocalDateTime dateTime;

}
