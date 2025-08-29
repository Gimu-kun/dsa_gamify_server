package com.example.dsa_gamify_be.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    private final String id = "L-" + UUID.randomUUID().toString().replace("-","").substring(0,8);

    @Column(name = "cp_id")
    private String checkPointId = null;

    @OneToOne
    @JoinColumn(name = "chapter_id", referencedColumnName = "id",   updatable = false, insertable = false)
    private Chapter chapter;

    @Column(name = "chapter_id")
    private Integer chapterId;

    @Column(unique = true)
    private String title;

    private String content;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;

    @Column(name = "created_at", insertable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<LessonImage> lessonImages = new ArrayList<>();

    public Lesson(){}

    public Lesson(Integer chapterId, String title, String content, String operator) {
        this.chapterId = chapterId;
        this.title = title;
        this.content = content;
        this.updatedBy = operator;
        this.createdBy = operator;
    }

    public String getId() {
        return id;
    }

    public String getCheckPointId() {
        return checkPointId;
    }

    public void setCheckPointId(String checkPointId) {
        this.checkPointId = checkPointId;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<LessonImage> getLessonImages() {
        return lessonImages;
    }

    public void setLessonImages(List<LessonImage> lessonImages) {
        this.lessonImages = lessonImages;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id='" + id + '\'' +
                ", checkPointId='" + checkPointId + '\'' +
                ", chapter=" + chapter +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", updatedAt=" + updatedAt +
                ", createdAt=" + createdAt +
                ", lessonImages=" + lessonImages +
                '}';
    }
}
