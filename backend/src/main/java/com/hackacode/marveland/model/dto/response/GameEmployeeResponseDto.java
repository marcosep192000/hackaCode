package com.hackacode.marveland.model.dto.response;

import com.hackacode.marveland.model.entity.Game;
import com.hackacode.marveland.model.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameEmployeeResponseDto {
	private Long id;
	private String firstName;
	private String lastName;
	private Integer dni;
	private String email;
	private LocalDateTime registrationDate;
	private String workingHours;
	private User user;
	private Game game;

}
