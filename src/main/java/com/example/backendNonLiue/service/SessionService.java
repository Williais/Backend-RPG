package com.example.backendNonLiue.service;

import com.example.backendNonLiue.model.Character;
import com.example.backendNonLiue.model.Session;
import com.example.backendNonLiue.model.SessionPlayer;
import com.example.backendNonLiue.repository.CharacterRepository;
import com.example.backendNonLiue.repository.SessionPlayerRepository;
import com.example.backendNonLiue.repository.SessionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final SessionRepository sessionRepository;
    private final SessionPlayerRepository sessionPlayerRepository;
    private final CharacterRepository characterRepository;

    @Transactional
    public SessionPlayer joinSession(UUID sessionId, UUID characterId) {
        sessionPlayerRepository.findBySessionIdAndCharacterId(sessionId, characterId)
                .ifPresent(sp -> { throw new IllegalStateException("Personagem já está nesta sessão."); });

        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("Sessão não encontrada."));

        Character character = characterRepository.findById(characterId)
                .orElseThrow(() -> new IllegalArgumentException("Personagem não encontrado."));

        SessionPlayer player = new SessionPlayer();
        player.setSession(session);
        player.setCharacter(character);
        player.setCurrentExistenceBoxes(3);
        player.setCurrentArmor(character.getAttrForma());
        player.setCurrentWillpower(character.getAttrOnirico() * 2);
        player.setCurrentDecisionPoints(0);
        player.setIsActive(true);

        return sessionPlayerRepository.save(player);
    }

    @Transactional
    public void processNextTurn(UUID sessionId) {
        List<SessionPlayer> activePlayers = sessionPlayerRepository.findAllActivePlayersWithCharacterData(sessionId);

        for (SessionPlayer player : activePlayers) {
            Character character = player.getCharacter();
            int newPd = (character.getAttrSaber() + character.getAttrSer()) / 2;
            player.setCurrentDecisionPoints(player.getCurrentDecisionPoints() + newPd);
        }

        sessionPlayerRepository.saveAll(activePlayers);
    }

    @Transactional
    public SessionPlayer updateExistenceBoxes(UUID sessionPlayerId, int boxesChange) {
        SessionPlayer player = sessionPlayerRepository.findById(sessionPlayerId)
                .orElseThrow(() -> new IllegalArgumentException("Jogador não encontrado na sessão."));

        int newBoxes = player.getCurrentExistenceBoxes() + boxesChange;

        if (newBoxes > 3) {
            newBoxes = 3;
        } else if (newBoxes <= 0) {
            newBoxes = 0;
            player.setIsActive(false);
        }

        player.setCurrentExistenceBoxes(newBoxes);
        return sessionPlayerRepository.save(player);
    }
}
