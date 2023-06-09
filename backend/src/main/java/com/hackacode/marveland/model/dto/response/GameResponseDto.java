package com.hackacode.marveland.model.dto.response;

import com.hackacode.marveland.model.entity.OpenHours;
import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameResponseDto implements Serializable {

    private Long id;

    private String description;

    private OpenHours openHours;
}
