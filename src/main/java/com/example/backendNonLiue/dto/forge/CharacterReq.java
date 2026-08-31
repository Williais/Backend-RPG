package com.example.backendNonLiue.dto.forge;

public record CharacterReq(
        String name,
        String archetype,
        String newbieBonusAttr,
        String lore,
        String imageUrl,
        Integer attrForma,
        Integer attrOnirico,
        Integer attrSaber,
        Integer attrSer
) {}