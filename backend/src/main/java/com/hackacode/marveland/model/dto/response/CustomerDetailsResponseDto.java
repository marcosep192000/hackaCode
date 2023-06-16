package com.hackacode.marveland.model.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import com.hackacode.marveland.model.entity.AdminEmployee;
import com.hackacode.marveland.model.entity.PurchaseDetails;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDetailsResponseDto {

    private Long id;

    private String firstName;

    private String lastName;

    private Integer dni;

    private String email;

    private String phone;

    private String birthdate;

    private LocalDateTime registrationDate;

	private AdminEmployee adminEmployee;

	private List<PurchaseDetails> purchases;
}
