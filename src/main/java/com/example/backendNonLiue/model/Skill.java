package com.example.backendNonLiue.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "effect_type")
    private String effectType;

    @Column(name = "effect_value")
    private Integer effectValue;

    @Column(name = "category")
    private String category;
    @Column(name = "icon_ref")
    private String iconRef;

    @Column(name = "damage_dice")
    private String damageDice;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}