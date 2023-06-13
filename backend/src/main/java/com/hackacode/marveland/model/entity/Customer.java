package com.hackacode.marveland.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.FetchType.EAGER;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CUSTOMER")
@SQLDelete(sql = "UPDATE CUSTOMER SET state = true WHERE id =?")
@Where(clause = "state=false")
@Entity
public class Customer {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "this field can not be blank")
	@Column(name = "FIRST_NAME")
	private String firstName;

	@NotBlank(message = "this field can not be blank")
	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "DNI")
	private  int dni;

	@NotBlank(message = "this field can not be blank")
	@Column(name = "EMAIL")
	private String email;

	@NotBlank(message = "this field can not be blank")
	@Column(name = "BIRTH_DATE")
	private String birthDate;

	private boolean state = Boolean.FALSE;
	@UpdateTimestamp
	@Column(name = "updated_on_date")
	private LocalDateTime updateDate;

	@ManyToOne(fetch = EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "adminEmployee_id")
	AdminEmployee adminEmployee;

	@OneToMany(fetch = EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "purchase_id")
	List<PurchaseDetails> purchases;
}