package com.example.dsa_gamify_be.service;

import com.example.dsa_gamify_be.dto.userDto.lesson.LessonCreationRequestDto;
import com.example.dsa_gamify_be.model.Lesson;
import com.example.dsa_gamify_be.model.LessonImage;
import com.example.dsa_gamify_be.model.User;
import com.example.dsa_gamify_be.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class LessonService {
    @Autowired
    LessonImageService lessonImageService;

    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    UserService userService;

    public ResponseEntity<String> createLesson(MultipartFile[] images, LessonCreationRequestDto req) throws IOException {
        User operator = userService.getById(req.getOperator());
        if (operator == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Lesson lesson = new Lesson(
                req.getChapterId(),
                req.getTitle(),
                req.getContent(),
                operator.getUsername()
        );
        lessonRepository.save(lesson);
        for (int i = 0; i < images.length; i++) {
            lessonImageService.saveImage(images[i],lesson.getId(),i+1);
        }
        return ResponseEntity.ok("Tạo bài học thành công");
    }

    public ResponseEntity<List<Lesson>> getAll(String operatorId){
        if (userService.getById(operatorId) == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(lessonRepository.findAll());
    }

    public ResponseEntity<Lesson> getById(String operatorId, String id) {
        if (userService.getById(operatorId) == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Optional<Lesson> lesson = lessonRepository.findById(id);
        return lesson.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
