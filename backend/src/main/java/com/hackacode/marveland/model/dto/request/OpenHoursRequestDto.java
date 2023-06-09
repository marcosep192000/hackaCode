package com.hackacode.marveland.model.dto.request;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpenHoursRequestDto implements Serializable {

    private Date startTime;

    private Date endTime;
}
