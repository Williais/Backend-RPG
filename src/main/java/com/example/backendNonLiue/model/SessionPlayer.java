package com.example.backendNonLiue.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_session_players")
public class SessionPlayer extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id", nullable = false)
    private Character character;

    @Column(name = "current_existence_boxes", nullable = false)
    private Integer currentExistenceBoxes = 3;

    @Column(name = "current_willpower", nullable = false)
    private Integer currentWillpower = 0;

    @Column(name = "current_decision_points", nullable = false)
    private Integer currentDecisionPoints = 0;

    @Column(name = "current_armor", nullable = false)
    private Integer currentArmor = 0;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
}
