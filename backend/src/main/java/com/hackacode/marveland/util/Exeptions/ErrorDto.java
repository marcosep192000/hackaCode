package com.hackacode.marveland.util.Exeptions;

import lombok.Builder;
import lombok.Data;
import org.aspectj.bridge.IMessage;

@Data
@Builder
public class ErrorDto {
	private String message;
    
}
