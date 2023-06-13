package com.hackacode.marveland.model.dto.request;

import com.hackacode.marveland.model.entity.OpenHours;
import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameRequestDto implements Serializable {
    private String description;
    private OpenHours openHours;

}
