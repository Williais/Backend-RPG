package com.example.backendNonLiue.dto.session;

import java.util.UUID;

public record AttackReq(
        UUID characterId,
        UUID skillId
) {}