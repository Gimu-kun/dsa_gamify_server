package com.example.dsa_gamify_be.dto.userDto.lesson;
import jakarta.validation.constraints.NotBlank;

public class LessonBaseDto {
    protected Integer chapterId;
    protected String title;
    protected String content;
    @NotBlank(message = "Chưa xác định được người thao tác")
    protected String operator;

    public LessonBaseDto(){}

    public LessonBaseDto(Integer chapterId, String title, String content, String operator) {
        this.chapterId = chapterId;
        this.title = title;
        this.content = content;
        this.operator = operator;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void getChapterId(Integer chapterId) {
        this.chapterId = chapterId;
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "LessonBaseDto{" +
                "chapterId=" + chapterId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }
}
