package com.example.dsa_gamify_be.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Chưa nhập hình ảnh cho huy hiệu")
    private String image;

    @NotBlank(message = "Chưa nhập tên cho huy hiệu")
    @Size(min = 6, max = 20, message = "Tên huy hiệu nằm trong khoảng 6-20 ký tự")
    private String name;

    @NotBlank(message = "Cấp độ huy hiệu không được để trống")
    @Positive(message = "Cấp độ huy hiệu phải là số nguyên dương")
    private Integer level;

    public Badge(){}

    public Badge(String image, String name, Integer level) {
        this.image = image;
        this.name = name;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Badge{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
