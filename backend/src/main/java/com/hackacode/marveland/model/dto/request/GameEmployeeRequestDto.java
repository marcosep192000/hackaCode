package com.hackacode.marveland.model.dto.request;
import com.hackacode.marveland.model.entity.Game;
import com.hackacode.marveland.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameEmployeeRequestDto {

	private String firstName;
	private String lastName;
	private Integer dni;
	private String email;
	private LocalDateTime registrationDate;
	private String workingHours;
	private User user;
	private Game game; private long games;
}
