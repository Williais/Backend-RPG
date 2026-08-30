package com.example.backendNonLiue.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Personagem {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;



}
