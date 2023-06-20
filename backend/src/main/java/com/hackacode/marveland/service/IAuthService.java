package com.hackacode.marveland.service;

import com.hackacode.marveland.model.dto.request.AuthRequestDto;
import com.hackacode.marveland.model.dto.request.RegisterRequestDto;
import com.hackacode.marveland.model.dto.response.AuthResponseDto;

public interface IAuthService {

    public AuthResponseDto register(RegisterRequestDto request);

    public AuthResponseDto login(AuthRequestDto request);
}
