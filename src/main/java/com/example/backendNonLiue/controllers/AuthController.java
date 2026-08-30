package com.example.backendNonLiue.controllers;

import com.example.backendNonLiue.dto.auth.AuthRes;
import com.example.backendNonLiue.dto.auth.LoginReq;
import com.example.backendNonLiue.dto.auth.RegisterReq;
import com.example.backendNonLiue.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthRes> register(@RequestBody RegisterReq req) {
        return ResponseEntity.ok(authService.register(req));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthRes> login(@RequestBody LoginReq req) {
        return ResponseEntity.ok(authService.login(req));
    }
}