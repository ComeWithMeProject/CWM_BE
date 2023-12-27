package com.cwm.develop.user.dto;


import com.cwm.develop.user.Role;
import com.cwm.develop.user.SocialType;
import com.cwm.develop.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserResponseDto {

    private Long userId;
    private String email;
    private String name;
    private int heart;
    private String imageUrl;
    private Role role;
    private SocialType socialType;
    private String socialId;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public UserResponseDto(User entity) {
        this.userId = entity.getUserId();
        this.email = entity.getEmail();
        this.name = entity.getName();
        this.heart = entity.getHeart();
        this.imageUrl = entity.getImageUrl();
        this.role = entity.getRole();
        this.socialType = entity.getSocialType();
        this.socialId = entity.getSocialId();
        this.createdAt = entity.getCreatedAt();
        this.modifiedAt = entity.getModifiedAt();
    }
}
