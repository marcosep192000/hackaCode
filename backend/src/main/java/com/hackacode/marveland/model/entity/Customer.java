package com.hackacode.marveland.model.entity;

import static jakarta.persistence.FetchType.EAGER;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CUSTOMERS")
@SQLDelete(sql = "UPDATE CUSTOMERS SET state = true WHERE id =?")
@Where(clause = "state=false")
@Entity
public class Customer {

	@Id
	@Column(name = "CUSTOMER_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "this field can not be blank")
	@Column(name = "FIRST_NAME")
	private String firstName;

	@NotBlank(message = "this field can not be blank")
	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "DNI")
	private Integer dni;

	@NotBlank(message = "this field can not be blank")
	@Column(name = "EMAIL")
	private String email;

	@NotBlank(message = "this field can not be blank")
	@Column(name = "PHONE")
	private String phone;

	@NotBlank(message = "this field can not be blank")
	@Column(name = "BIRTHDATE")
	private String birthdate;

	@Column(name = "STATE")
	@Default
	private boolean state = Boolean.FALSE;

	@UpdateTimestamp
	@Column(name = "UPDATE_DATE")
	private LocalDateTime updateDate;

	@ManyToOne(fetch = EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ADMIN_EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID", insertable = false, updatable = false)
	private AdminEmployee adminEmployee;

	@OneToMany(mappedBy = "customer")
	private List<PurchaseDetails> purchases;
}