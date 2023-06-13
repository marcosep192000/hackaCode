package com.hackacode.marveland.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ADMIN_EMPLOYEE")
public class AdminEmployee extends Person {

	@UpdateTimestamp
	@Column(name = "updated_on_date")
	private LocalDateTime updateDate;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "adminEmployee" )
	@JsonIgnoreProperties("adminEmployee")
	private List<Customer> customerList = new ArrayList<>();
}