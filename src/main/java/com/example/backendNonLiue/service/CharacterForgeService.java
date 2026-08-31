package com.example.backendNonLiue.service;

import com.example.backendNonLiue.dto.forge.CharacterItemRes;
import com.example.backendNonLiue.dto.forge.CharacterReq;
import com.example.backendNonLiue.dto.forge.CharacterRes;
import com.example.backendNonLiue.dto.forge.EquipReq;
import com.example.backendNonLiue.model.CharacterItem;
import com.example.backendNonLiue.model.Item;
import com.example.backendNonLiue.model.Character;
import com.example.backendNonLiue.model.User;
import com.example.backendNonLiue.model.keys.CharacterItemKey;
import com.example.backendNonLiue.repository.CharacterItemRepository;
import com.example.backendNonLiue.repository.CharacterRepository;
import com.example.backendNonLiue.repository.ItemRepository;
import com.example.backendNonLiue.repository.UserRepository;
import com.example.backendNonLiue.util.Archetype;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CharacterForgeService {

    private final CharacterRepository characterRepository;
    private final ItemRepository itemRepository;
    private final CharacterItemRepository characterItemRepository;
    private final UserRepository userRepository;

    @Transactional
    public void equipItem(EquipReq req) {
        Character character = characterRepository.findById(req.characterId())
                .orElseThrow(RuntimeException::new);

        Item item = itemRepository.findById(req.targetId())
                .orElseThrow(RuntimeException::new);

        CharacterItem characterItem = new CharacterItem();

        CharacterItemKey key = new CharacterItemKey();
        key.setCharacterId(character.getId());
        key.setItemId(item.getId());

        characterItem.setId(key);
        characterItem.setCharacter(character);
        characterItem.setItem(item);
        characterItem.setQuantity(req.quantity() > 0 ? req.quantity() : 1);

        characterItemRepository.save(characterItem);
    }

    public CharacterRes getCharacter(UUID id) {
        Character c = characterRepository.findById(id).orElseThrow(RuntimeException::new);
        return mapToRes(c);
    }

    public List<CharacterRes> getMyCharacters(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(RuntimeException::new);
        return characterRepository.findByUser(user).stream().map(this::mapToRes).collect(Collectors.toList());
    }

    private CharacterRes mapToRes(Character c) {
        List<CharacterItemRes> items = characterItemRepository.findByCharacter(c).stream()
                .map(ci -> new CharacterItemRes(ci.getItem().getId(), ci.getItem().getName(), ci.getQuantity()))
                .collect(Collectors.toList());

        return new CharacterRes(
                c.getId(),
                c.getName(),
                c.getArchetype().name(),
                c.getAttrForma(),
                c.getAttrOnirico(),
                c.getAttrSaber(),
                c.getAttrSer(),
                items
        );
    }

    @Transactional
    public Character forgeNewCharacter(CharacterReq req, String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        Character character = new Character();
        character.setName(req.name());
        Archetype archetypeEnum = Archetype.valueOf(req.archetype());
        character.setArchetype(archetypeEnum);
        character.setLore(req.lore());
        character.setImageUrl(req.imageUrl());
        character.setUser(user);

        applyArchetypeBonus(character, archetypeEnum, req);

        return characterRepository.save(character);
    }

    private void applyArchetypeBonus(Character character, Archetype archetype, CharacterReq req) {
        int forma = req.attrForma() != null ? req.attrForma() : 0;
        int onirico = req.attrOnirico() != null ? req.attrOnirico() : 0;
        int saber = req.attrSaber() != null ? req.attrSaber() : 0;
        int ser = req.attrSer() != null ? req.attrSer() : 0;

        switch (archetype) {
            case ONIROMANTE, INTERCESSOR, AUROR, FUSIONISTA, MASKRA -> onirico += 1;
            case ETERISTA, EUREKA, ONIRITOGRAFO, ALQUIMICOS , ARTESAO -> saber += 1;
            case MARECHAL, ESMOS, POPSTAR, CAVALIER -> ser += 1;
            case VANGUARDISTA, DUELISTA, PUGILISTA, UMBRAIS, GATILHOS, MAGENS, ALTERS -> forma += 1;
            case NEWBIE -> {
                if (req.newbieBonusAttr() != null) {
                    switch (req.newbieBonusAttr().toUpperCase()) {
                        case "FORMA" -> forma += 1;
                        case "ONIRICO" -> onirico += 1;
                        case "SABER" -> saber += 1;
                        case "SER" -> ser += 1;
                        default -> throw new IllegalArgumentException("Atributo bônus de Newbie inválido.");
                    }
                } else {
                    throw new IllegalArgumentException("Jogadores Newbie precisam enviar o 'newbieBonusAttr'.");
                }
            }
        }

        character.setAttrForma(forma);
        character.setAttrOnirico(onirico);
        character.setAttrSaber(saber);
        character.setAttrSer(ser);
    }
}