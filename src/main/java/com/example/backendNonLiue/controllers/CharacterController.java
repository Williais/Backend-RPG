package com.example.backendNonLiue.controllers;

import com.example.backendNonLiue.dto.forge.CharacterReq;
import com.example.backendNonLiue.dto.forge.CharacterRes;
import com.example.backendNonLiue.dto.forge.EquipReq;
import com.example.backendNonLiue.model.Character;
import com.example.backendNonLiue.model.User;
import com.example.backendNonLiue.util.Archetype;
import com.example.backendNonLiue.repository.CharacterRepository;
import com.example.backendNonLiue.repository.UserRepository;
import com.example.backendNonLiue.service.CharacterForgeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/characters")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterRepository characterRepository;
    private final CharacterForgeService forgeService;
    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Character> createCharacter(@RequestBody CharacterReq req, Authentication authentication) {
        Character forgedCharacter = forgeService.forgeNewCharacter(req, authentication.getName());
        return ResponseEntity.ok(forgedCharacter);
    }
    @PostMapping("/equip-item")
    public ResponseEntity<Void> equipItemToCharacter(@RequestBody EquipReq req) {
        forgeService.equipItem(req);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterRes> getCharacter(@PathVariable UUID id) {
        return ResponseEntity.ok(forgeService.getCharacter(id));
    }

    @GetMapping("/my")
    public ResponseEntity<List<CharacterRes>> getMyCharacters(Authentication authentication) {
        return ResponseEntity.ok(forgeService.getMyCharacters(authentication.getName()));
    }
}