package com.example.backendNonLiue.dto;

import java.util.UUID;

public record JoinSessionReq(
        UUID characterId,
        String password
) {}