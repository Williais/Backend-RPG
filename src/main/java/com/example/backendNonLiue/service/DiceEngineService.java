package com.example.backendNonLiue.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class DiceEngineService {

    private final Random random = new Random();

    public int rollDice(int faces) {
        if (faces <= 0) return 0;
        return random.nextInt(faces) + 1;
    }

    public int executeAttributeRoll(int attributeValue) {
        return switch (attributeValue) {
            case 5 -> rollMultiple(6, 6);
            case 4 -> rollAndKeepHighest(6, 6, 4);
            case 3 -> rollAndKeepHighest(5, 6, 3);
            case 2 -> rollAndKeepHighest(3, 6, 2);
            case 1 -> rollMultiple(2, 6) + 1;
            case 0 -> rollMultiple(2, 6);
            case -1 -> rollAndKeepLowest(2, 6, 1);
            case -2 -> rollMultiple(1, 6);
            case -3 -> rollMultiple(1, 6) - 1;
            case -4 -> rollMultiple(1, 6) - 2;
            case -5 -> 0;
            default -> 0;
        };
    }

    private int rollMultiple(int numDice, int faces) {
        int total = 0;
        for (int i = 0; i < numDice; i++) {
            total += rollDice(faces);
        }
        return total;
    }

    private int rollAndKeepHighest(int numDice, int faces, int keep) {
        List<Integer> rolls = new ArrayList<>();
        for (int i = 0; i < numDice; i++) {
            rolls.add(rollDice(faces));
        }
        rolls.sort(Collections.reverseOrder());

        return rolls.stream().limit(keep).mapToInt(Integer::intValue).sum();
    }

    private int rollAndKeepLowest(int numDice, int faces, int keep) {
        List<Integer> rolls = new ArrayList<>();
        for (int i = 0; i < numDice; i++) {
            rolls.add(rollDice(faces));
        }
        Collections.sort(rolls);

        return rolls.stream().limit(keep).mapToInt(Integer::intValue).sum();
    }
}