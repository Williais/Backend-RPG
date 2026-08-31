package com.example.backendNonLiue.dto.forge;

import java.util.List;
import java.util.UUID;

public record CharacterRes(
        UUID id,
        String name,
        String archetype,
        Integer attrForma,
        Integer attrOnirico,
        Integer attrSaber,
        Integer attrSer,
        List<CharacterItemRes> items
) {}