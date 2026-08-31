package com.example.backendNonLiue.controllers;

import com.example.backendNonLiue.dto.DamageReq;
import com.example.backendNonLiue.dto.JoinSessionReq;
import com.example.backendNonLiue.dto.PlayerStatusSyncRes;
import com.example.backendNonLiue.dto.session.DiceRollMessage;
import com.example.backendNonLiue.dto.session.SessionRes;
import com.example.backendNonLiue.model.GameSession;
import com.example.backendNonLiue.model.SessionPlayer;
import com.example.backendNonLiue.model.User;
import com.example.backendNonLiue.repository.GameSessionRepository;
import com.example.backendNonLiue.repository.UserRepository;
import com.example.backendNonLiue.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/sessions")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;
    private final SimpMessagingTemplate messagingTemplate;
    private final GameSessionRepository sessionRepository;
    private final UserRepository userRepository;

    @PostMapping("/api/sessions")
    public ResponseEntity<SessionRes> createSession(Authentication auth) {
        User master = userRepository.findByEmail(auth.getName()).orElseThrow(RuntimeException::new);

        GameSession session = new GameSession();
        session.setMaster(master);
        session.setInviteCode(UUID.randomUUID().toString().substring(0, 6).toUpperCase());

        sessionRepository.save(session);
        return ResponseEntity.ok(new SessionRes(session.getInviteCode()));
    }

    @MessageMapping("/roll")
    @SendTo("/topic/dice")
    public DiceRollMessage broadcastRoll(DiceRollMessage message) {
        return message;
    }

    @PostMapping("/{sessionId}/join")
    public ResponseEntity<SessionPlayer> joinSession(@PathVariable UUID sessionId, @RequestBody JoinSessionReq req) {
        SessionPlayer player = sessionService.joinSession(sessionId, req.characterId());
        return ResponseEntity.ok(player);
    }

    @PostMapping("/{sessionId}/next-turn")
    public ResponseEntity<Void> nextTurn(@PathVariable UUID sessionId) {
        sessionService.processNextTurn(sessionId);
        messagingTemplate.convertAndSend("/topic/session/" + sessionId + "/turn", "NEXT_TURN");
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{sessionId}/damage")
    public ResponseEntity<Void> applyDamage(@PathVariable UUID sessionId, @RequestBody DamageReq req) {
        SessionPlayer player = sessionService.updateExistenceBoxes(req.playerId(), -req.damage());

        PlayerStatusSyncRes syncData = new PlayerStatusSyncRes(
                player.getId(),
                player.getCurrentExistenceBoxes(),
                player.getCurrentWillpower(),
                player.getCurrentDecisionPoints(),
                player.getCurrentArmor(),
                player.getIsActive()
        );

        messagingTemplate.convertAndSend("/topic/session/" + sessionId, syncData);
        return ResponseEntity.ok().build();
    }
}