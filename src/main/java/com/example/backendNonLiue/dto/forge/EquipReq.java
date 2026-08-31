package com.example.backendNonLiue.dto.forge;

import java.util.UUID;

public record EquipReq(UUID characterId, UUID targetId, int quantity) {}
