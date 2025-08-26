package com.example.dsa_gamify_be.model;

import com.example.dsa_gamify_be.enums.UserRoleEnum;
import com.example.dsa_gamify_be.enums.UserStatusEnum;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column( unique = true , nullable = false )
    private final String id = UUID.randomUUID().toString().replace("-","").substring(0,10);

    @Column( unique = true , nullable = false)
    private String username;

    @Column( name = "full_name", nullable = false )
    private String fullName;

    @Column( nullable = false )
    private String passwords;

    private Integer exp = 0;

    @Column( name = "badge_id")
    private Integer badgeId = 1;

    @Enumerated(EnumType.STRING)
    private UserStatusEnum status = UserStatusEnum.active;

    @Enumerated(EnumType.STRING)
    private UserRoleEnum role = UserRoleEnum.student;

    private Integer coin = 0;

    @Column( name = "created_at", nullable = true, insertable = false)
    private LocalDateTime createdAt;

    @Column( name = "updated_at", nullable = true, insertable = false)
    private LocalDateTime updatedAt;

    @Column( name = "updated_by", nullable = true)
    private String updatedBy;

    public User(){};

    public User(String username, String fullName, String passwords) {
        this.username = username;
        this.fullName = fullName;
        this.passwords = passwords;
        this.updatedBy = username;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Integer getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(Integer badgeId) {
        this.badgeId = badgeId;
    }

    public UserStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UserStatusEnum status) {
        this.status = status;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", passwords='" + passwords + '\'' +
                ", exp=" + exp +
                ", badgeId=" + badgeId +
                ", status=" + status +
                ", role=" + role +
                ", coin=" + coin +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
