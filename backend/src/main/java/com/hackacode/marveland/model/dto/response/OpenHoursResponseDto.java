package com.hackacode.marveland.model.dto.response;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpenHoursResponseDto implements Serializable {

    private Long id;

    @NotBlank(message = "this field can not be blank")
    @Column(name = "START_TIME")
    private Date startTime;

    @NotBlank(message = "this field can not be blank")
    @Column(name = "END_TIME")
    private Date endTime;
}
