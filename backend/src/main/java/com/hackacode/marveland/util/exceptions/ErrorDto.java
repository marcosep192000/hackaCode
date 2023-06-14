package com.hackacode.marveland.util.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto {
	
	private String message;
}
