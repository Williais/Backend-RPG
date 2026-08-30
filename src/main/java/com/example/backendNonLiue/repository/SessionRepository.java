package com.example.backendNonLiue.repository;

import com.example.backendNonLiue.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SessionRepository extends JpaRepository<Session, UUID> {
}
