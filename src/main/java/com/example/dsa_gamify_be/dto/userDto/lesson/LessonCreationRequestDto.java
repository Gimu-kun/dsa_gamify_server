package com.example.dsa_gamify_be.dto.userDto.lesson;

import com.example.dsa_gamify_be.model.Chapter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LessonCreationRequestDto extends LessonBaseDto {
    @NotBlank(message = "Chưa nhập tiêu đề")
    @Size(min = 4, max = 30, message = "Tiêu đề phải có độ dài trong khoảng 4-30 ký tự")
    private String title;

    @NotNull(message = "Chưa lựa chọn chương")
    private Integer chapterId;

    @NotBlank(message = "Chưa nhập nội dung")
    private String content;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }
}
