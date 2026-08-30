package com.example.backendNonLiue.repository;

import com.example.backendNonLiue.model.SessionPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SessionPlayerRepository extends JpaRepository<SessionPlayer, UUID> {

    Optional<SessionPlayer> findBySessionIdAndCharacterId(UUID sessionId, UUID characterId);

    @Query("SELECT sp FROM SessionPlayer sp JOIN FETCH sp.character WHERE sp.session.id = :sessionId AND sp.isActive = true")
    List<SessionPlayer> findAllActivePlayersWithCharacterData(@Param("sessionId") UUID sessionId);
}