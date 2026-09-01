package com.example.backendNonLiue.dto.session;

public record GameLogRes(
        String characterName,
        String actionText,
        Integer totalValue
) {}