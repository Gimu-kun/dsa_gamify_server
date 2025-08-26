package com.example.dsa_gamify_be.repository;

import com.example.dsa_gamify_be.model.Badge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BadgeRepository extends JpaRepository<Badge,Integer> {
    Optional<Badge> findByLevel(Integer level);
}
