package com.example.dsa_gamify_be.service;

import com.example.dsa_gamify_be.model.LessonImage;
import com.example.dsa_gamify_be.repository.LessonImageRepository;
import com.example.dsa_gamify_be.repository.LessonRepository;
import com.example.dsa_gamify_be.utils.FirebaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class LessonImageService {
    @Autowired
    FirebaseUtil firebaseUtil;

    @Autowired
    LessonImageRepository lessonImageRepository;

    public void saveImage(MultipartFile image, String id, Integer order) throws IOException {
      String url =  firebaseUtil.uploadImage(image,id+order);
      LessonImage lessonImage = new LessonImage(id,order,url);
      lessonImageRepository.save(lessonImage);
    }
}
