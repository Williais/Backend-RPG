package com.example.backendNonLiue.repository;

import com.example.backendNonLiue.model.Character;
import com.example.backendNonLiue.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface CharacterRepository extends JpaRepository<Character, UUID> {

    List<Character> findByUser(User user);
}
