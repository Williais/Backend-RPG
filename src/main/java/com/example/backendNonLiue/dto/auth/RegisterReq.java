package com.example.backendNonLiue.dto.auth;

public record RegisterReq(String name, String email, String password, String masterSecret) {
}
