package com.example.backendNonLiue.repository;

import com.example.backendNonLiue.model.GameSession;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface GameSessionRepository extends JpaRepository<GameSession, UUID> {
    Optional<GameSession> findByInviteCode(String inviteCode);
}