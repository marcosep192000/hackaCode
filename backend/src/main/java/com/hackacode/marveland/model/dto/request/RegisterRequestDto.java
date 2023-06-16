package com.hackacode.marveland.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class RegisterRequestDto {

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Incorrect format")
    private String username;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 3, max = 10, message = "min 8 characters max 20")
    private String password;

    @NotBlank(message = "Role cannot be blank")
    private String role;

    @NotBlank(message = "First name cannot be blank")
    @Size(min = 3, max = 50, message = "min 3 characters max 50")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(min = 3, max = 50, message = "min 3 characters max 50")
    private String lastName;

    @NotNull(message = "DNI cannot be null")
    private Integer dni;

    @NotBlank(message = "Working hours cannot be blank")
    private String workingHours;
}
