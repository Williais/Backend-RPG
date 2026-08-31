package com.example.backendNonLiue.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Table(name = "tb_sessions")
@Data
public class GameSession {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String inviteCode;

    @ManyToOne
    @JoinColumn(name = "master_id")
    private User master;
}