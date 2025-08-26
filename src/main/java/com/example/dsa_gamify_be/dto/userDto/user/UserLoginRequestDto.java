package com.example.dsa_gamify_be.dto.userDto.user;

import jakarta.validation.constraints.NotBlank;

public class UserLoginRequestDto extends UserBaseDto {
    @Override
    @NotBlank(message = "Tài khoản không được để trống")
    public String getUsername() {
        return username;
    }

    @Override
    @NotBlank(message = "Mật khẩu không được để trống")
    public String getPasswords() {
        return passwords;
    }

    public UserLoginRequestDto(){}

    public UserLoginRequestDto(String username, String passwords) {
        super(username, passwords);
    }

    @Override
    public String toString() {
        return "UserLoginRequestDto{" +
                "username='" + username + '\'' +
                ", passwords='" + passwords + '\'' +
                '}';
    }
}
