package com.example.backendNonLiue.dto;

import java.util.UUID;

public record PlayerStatusSyncRes(
        UUID playerId,
        int existenceBoxes,
        int willpower,
        int decisionPoints,
        int armor,
        boolean isActive
) {}