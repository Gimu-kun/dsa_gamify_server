package com.example.dsa_gamify_be.dto.userDto.user;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;

public class UserBaseDto {
    @Size(min = 6, max = 20, message = "Tài khoản nằm trong khoảng từ 6-20 kí tự")
    @Column(unique = true)
    protected String username;

    @Size(min = 6, max = 12, message = "Mật khẩu nằm trong khoảng từ 6-12 kí tự")
    protected String passwords;

    protected UserBaseDto(){}

    protected UserBaseDto(String username, String passwords) {
        this.username = username;
        this.passwords = passwords;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }
}
