package com.hexaware.hotpot.service;

import com.hexaware.hotpot.dto.JWTAuthResponse;
import com.hexaware.hotpot.dto.LoginDto;
import com.hexaware.hotpot.dto.RegisterDto;

public interface AuthService {
    JWTAuthResponse login(LoginDto dto);
    String register(RegisterDto dto);
}

