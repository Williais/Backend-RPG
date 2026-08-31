package com.example.backendNonLiue.repository;

import com.example.backendNonLiue.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {
}
