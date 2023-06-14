package com.hackacode.marveland.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {

    @Email(message = "incorrect format")
    private String username;

    @NotBlank(message = "this field can not be blank")
    @Size(min = 3, max = 10, message = "min 8 characters max 20")
    private String password;

    private String role;

    @NotBlank(message = "this field can not be blank")
    @Size(min = 3, max = 50, message = "min 3 characters max 50")
    private String firstName;

    @NotBlank(message = "this field can not be blank")
    @Size(min = 3, max = 50, message = "min 3 characters max 50")
    private String lastName;

    private Integer dni;

    @NotBlank(message = "this field can not be blank")
    private String workingHours;
}
