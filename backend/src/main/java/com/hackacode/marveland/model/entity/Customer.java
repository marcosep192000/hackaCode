package com.hackacode.marveland.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "CUSTOMERS")
@SQLDelete(sql = "UPDATE CUSTOMERS SET state = true WHERE id =?")
@Where(clause = "state = false")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

	@Id
	@Column(name = "CUSTOMER_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "DNI")
	private Integer dni;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "BIRTHDATE")
	private String birthdate;

	@Column(name = "STATE")
	private boolean state = Boolean.FALSE;

	@UpdateTimestamp
	@Column(name = "REGISTRATION_DATE")
	private LocalDateTime registrationDate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ADMIN_EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID", insertable = false, updatable = false)
	private AdminEmployee adminEmployee;

	@OneToMany(mappedBy = "customer")
	private List<PurchaseDetails> purchases;
}