package com.example.backendNonLiue.controllers;

import com.example.backendNonLiue.dto.ItemSkillReq;
import com.example.backendNonLiue.model.Item;
import com.example.backendNonLiue.model.Skill;
import com.example.backendNonLiue.repository.ItemRepository;
import com.example.backendNonLiue.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final ItemRepository itemRepository;
    private final SkillRepository skillRepository;

    private void verifyMasterRole() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ROLE_MASTER"))) {
            throw new SecurityException("Apenas o Mestre pode alterar o catálogo.");
        }
    }

    @PostMapping("/items")
    public ResponseEntity<Item> createItem(@RequestBody ItemSkillReq req) {
        verifyMasterRole();

        Item item = new Item();
        item.setName(req.name());
        item.setDescription(req.description());
        item.setEffectType(req.effectType());
        item.setEffectValue(req.effectValue());

        return ResponseEntity.ok(itemRepository.save(item));
    }

    @PostMapping("/skills")
    public ResponseEntity<Skill> createSkill(@RequestBody ItemSkillReq req) {
        verifyMasterRole();

        Skill skill = new Skill();
        skill.setName(req.name());
        skill.setDescription(req.description());
        skill.setEffectType(req.effectType());
        skill.setEffectValue(req.effectValue());

        return ResponseEntity.ok(skillRepository.save(skill));
    }
}