package com.example.backendNonLiue.service;

import com.example.backendNonLiue.dto.auth.AuthRes;
import com.example.backendNonLiue.dto.auth.LoginReq;
import com.example.backendNonLiue.dto.auth.RegisterReq;
import com.example.backendNonLiue.model.User;
import com.example.backendNonLiue.util.Role;
import com.example.backendNonLiue.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private static final String MASTER_SECRET_KEY = "MALL_WORLD_2026";

    public AuthRes register(RegisterReq req) {
        if (userRepository.findByEmail(req.email()).isPresent()) {
            throw new IllegalArgumentException("Email já cadastrado.");
        }

        Role userRole = (req.masterSecret() != null && req.masterSecret().equals(MASTER_SECRET_KEY))
                ? Role.MASTER
                : Role.PLAYER;

        User user = new User();
        user.setName(req.name());
        user.setEmail(req.email());
        user.setPasswordHash(passwordEncoder.encode(req.password()));
        user.setRole(userRole);

        userRepository.save(user);

        String jwtToken = jwtService.generateToken(user.getEmail(), user.getRole().name());
        return new AuthRes(jwtToken, user.getRole().name());
    }

    public AuthRes login(LoginReq req) {
        User user = userRepository.findByEmail(req.email())
                .orElseThrow(() -> new IllegalArgumentException("Credenciais inválidas."));

        if (!passwordEncoder.matches(req.password(), user.getPasswordHash())) {
            throw new IllegalArgumentException("Credenciais inválidas.");
        }

        String jwtToken = jwtService.generateToken(user.getEmail(), user.getRole().name());
        return new AuthRes(jwtToken, user.getRole().name());
    }
}