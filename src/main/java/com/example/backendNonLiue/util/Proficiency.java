package com.example.backendNonLiue.util;

public enum Proficiency {
    RUIM("-3"),
    COMUM("0"),
    TREINADO("1d4"),
    NERD("1d8"),
    MESTRE("1d20");

    private final String bonusDice;
    Proficiency(String bonusDice) { this.bonusDice = bonusDice; }
    public String getBonusDice() { return bonusDice; }
}