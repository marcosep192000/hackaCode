package com.hackacode.marveland.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameEmployeeRequestDto {
    @NotBlank(message = "this field can not be blank")
    private String firstName;
    @NotBlank(message = "this field can not be blank")
    private String lastName;

    private Integer dni;
    @NotBlank(message = "this field can not be blank")
    private String email;
    @NotBlank(message = "this field can not be blank")
    private String password;
    @NotBlank(message = "this field can not be blank")
    private String workingHours;
}
