package com.example.dsa_gamify_be.dto.userDto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserCreationRequestDto extends  UserBaseDto{
    @NotBlank(message = "Tài khoản không được để trống")
    @Override
    public String getUsername() {
        return username;
    }

    @NotBlank(message = "Mật khẩu không được để trống")
    @Override
    public String getPasswords() {
        return passwords;
    }

    @NotBlank(message = "Họ tên không được để trống")
    @Size(max = 30, message = "Họ tên nhiều nhất 30 kí tự")
    private String fullName;

    public UserCreationRequestDto() {}

    public UserCreationRequestDto(String username, String passwords, String fullName) {
        super(username, passwords);
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "UserCreationRequestDto{" +
                "fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", passwords='" + passwords + '\'' +
                '}';
    }
}
