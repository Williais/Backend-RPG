package com.example.backendNonLiue.dto;

import java.util.UUID;

public record DamageReq(
        UUID playerId,
        int damage
) {}