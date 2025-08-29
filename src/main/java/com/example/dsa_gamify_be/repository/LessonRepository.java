package com.example.dsa_gamify_be.repository;

import com.example.dsa_gamify_be.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository<Lesson,String> {
    Optional<Lesson> findByTitle(String title);
}
