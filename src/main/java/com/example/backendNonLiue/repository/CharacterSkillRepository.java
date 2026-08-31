package com.example.backendNonLiue.repository;

import com.example.backendNonLiue.model.CharacterSkill;
import com.example.backendNonLiue.model.keys.CharacterSkillKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterSkillRepository extends JpaRepository<CharacterSkill, CharacterSkillKey> {
}
