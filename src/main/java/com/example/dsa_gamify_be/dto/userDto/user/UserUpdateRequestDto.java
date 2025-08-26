package com.example.dsa_gamify_be.dto.userDto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserUpdateRequestDto extends UserBaseDto {
    @Size(max = 30, message = "Họ tên nhiều nhất 30 kí tự")
    private String fullName;

    @Size(min = 6, max = 12, message = "Mật khẩu xác nhận phải nằm trong khoảng từ 6-12 kí tự")
    @NotBlank(message = "Mật khẩu xác nhận không được để trống")
    private String confirmPasswords;

    private String operatorId;

    public UserUpdateRequestDto() {}

    public UserUpdateRequestDto(String username, String passwords, String fullName, String confirmPasswords, String operatorId) {
        super(username, passwords);
        this.fullName = fullName;
        this.confirmPasswords = confirmPasswords;
        this.operatorId = operatorId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getConfirmPasswords() {
        return confirmPasswords;
    }

    public void setConfirmPasswords(String confirmPasswords) {
        this.confirmPasswords = confirmPasswords;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
}
