package com.example.backendNonLiue.dto.forge;

import java.util.UUID;

public record CharacterItemRes(
        UUID itemId,
        String name,
        int quantity
) {}