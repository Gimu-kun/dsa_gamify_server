package com.example.dsa_gamify_be.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "lesson_images")
public class LessonImage {
    @Id
    private final String id = "LI-" + UUID.randomUUID().toString().replace("-","").substring(0,7);

    @ManyToOne
    @JoinColumn(name = "ls_id", nullable = false, insertable = false, updatable = false)
    private Lesson lesson;

    @Column(name = "ls_id")
    private String lessonId;

    @Column(name = "ord")
    private Integer order;

    private String url;

    private String caption = "";

    @Column(name = "created_at", insertable = false)
    private LocalDateTime createdAt;

    public LessonImage(){}

    public LessonImage(String lessonId, Integer order, String url) {
        this.lessonId = lessonId;
        this.order = order;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "LessonImage{" +
                "id='" + id + '\'' +
                ", lesson=" + lesson +
                ", lessonId='" + lessonId + '\'' +
                ", order=" + order +
                ", url='" + url + '\'' +
                ", caption='" + caption + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
