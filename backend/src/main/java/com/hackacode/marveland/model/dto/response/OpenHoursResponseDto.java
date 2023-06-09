package com.hackacode.marveland.model.dto.response;

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

    private Date startTime;

    private Date endTime;
}
