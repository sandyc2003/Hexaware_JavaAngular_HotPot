package com.hexaware.hotpot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.hotpot.dto.JWTAuthResponse;
import com.hexaware.hotpot.dto.LoginDto;
import com.hexaware.hotpot.dto.RegisterDto;
import com.hexaware.hotpot.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(value = { "/register", "/signup" })
    public ResponseEntity<String> register(@RequestBody RegisterDto dto) {
        String response = authService.register(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping(value = { "/login", "/signin" })
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto dto) {
        JWTAuthResponse response = authService.login(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
