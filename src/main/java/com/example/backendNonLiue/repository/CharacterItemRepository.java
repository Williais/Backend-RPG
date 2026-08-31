package com.example.backendNonLiue.repository;

import com.example.backendNonLiue.model.CharacterItem;
import com.example.backendNonLiue.model.Character;
import com.example.backendNonLiue.model.keys.CharacterItemKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterItemRepository extends JpaRepository<CharacterItem, CharacterItemKey> {
    List<CharacterItem> findByCharacter(Character character);
}
