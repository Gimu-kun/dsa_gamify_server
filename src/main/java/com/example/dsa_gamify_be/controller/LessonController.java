package com.example.dsa_gamify_be.controller;

import com.example.dsa_gamify_be.dto.userDto.lesson.LessonCreationRequestDto;
import com.example.dsa_gamify_be.dto.userDto.lesson.LessonUpdateRequestDto;
import com.example.dsa_gamify_be.model.Lesson;
import com.example.dsa_gamify_be.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/lesson")
@CrossOrigin("*")
public class LessonController {
    @Autowired
    LessonService lessonService;

    @PostMapping
    public ResponseEntity<String> createNew(@ModelAttribute @Validated LessonCreationRequestDto req, @RequestParam MultipartFile[] images){
        try {
            return lessonService.createLesson(images,req);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to create lesson: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Lesson>> getAll(@RequestParam String operatorId){
        return lessonService.getAll(operatorId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lesson> getById(@RequestParam String operatorId, @PathVariable String id){
        return lessonService.getById(operatorId,id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Lesson> updateDetail(@PathVariable String id,@RequestBody LessonUpdateRequestDto req){
        return lessonService.updateDetail(id,req);
    }
}
