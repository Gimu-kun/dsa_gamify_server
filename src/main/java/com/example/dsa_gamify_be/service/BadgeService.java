package com.example.dsa_gamify_be.service;

import com.example.dsa_gamify_be.model.Badge;
import com.example.dsa_gamify_be.repository.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BadgeService {
    @Autowired
    BadgeRepository badgeRepository;

    private boolean isLevelExisted(Integer level){
        Optional<Badge> badge = badgeRepository.findByLevel(level);
        return badge.isPresent();
    }

    public List<Badge> getAll(){
        return badgeRepository.findAll();
    }

    public Badge getById(Integer id){
        return badgeRepository.findById(id).orElse(null);
    }
}
