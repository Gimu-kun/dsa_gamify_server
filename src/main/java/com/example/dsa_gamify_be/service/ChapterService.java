package com.example.dsa_gamify_be.service;

import com.example.dsa_gamify_be.model.Chapter;
import com.example.dsa_gamify_be.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChapterService {
    @Autowired
    ChapterRepository chapterRepository;

    public String getDisplayName(Integer id){
        Optional<Chapter> chapter = chapterRepository.findById(id);
        return chapter.map(Chapter::getDisplayName).orElse(null);
    }

    public boolean isExisted(Integer id){
        return chapterRepository.findById(id).isPresent();
    }
}
