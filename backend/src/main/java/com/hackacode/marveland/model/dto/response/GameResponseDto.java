package com.hackacode.marveland.model.dto.response;

import com.hackacode.marveland.model.entity.OpenHours;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameResponseDto implements Serializable {

    private Long id;

    @NotBlank(message = "this field can not be blank")
    @Column(name = "DESCRIPTION")
    private String description;

    @NotBlank(message = "this field can not be blank")
    @Column(name = "OPEN_HOURS")
    private OpenHours openHours;
}
