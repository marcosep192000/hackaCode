package com.hackacode.marveland.model.dto.request;

import jakarta.validation.constraints.NotBlank;
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
public class AuthRequestDto {

    @NotBlank(message = "Email cannot be blank")
    private String username;

    @NotBlank(message = "Password cannot be blank")
    private String password;
}