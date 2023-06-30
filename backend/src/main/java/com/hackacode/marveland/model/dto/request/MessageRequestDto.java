package com.hackacode.marveland.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
public class MessageRequestDto {

    @NotBlank(message = "Details cannot be blank")
    private String details;

    @NotEmpty(message = "Customer request list cannot be empty")
    private CustomerRequestDto customerRequest;
}
