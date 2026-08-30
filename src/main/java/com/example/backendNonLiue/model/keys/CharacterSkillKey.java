package com.example.backendNonLiue.model.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class CharacterSkillKey implements Serializable {
    @Column(name = "character_id")
    private UUID characterId;

    @Column(name = "skill_id")
    private UUID skillId;
}