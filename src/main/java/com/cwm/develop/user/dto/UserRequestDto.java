package com.cwm.develop.user.dto;

import com.cwm.develop.user.Role;
import com.cwm.develop.user.SocialType;
import lombok.Getter;

import javax.persistence.*;

//@Setter
//@NoArgsConstructor
@Getter
public class UserRequestDto {

    private String email;
    private String name;
    private String password;
    private Integer heart;
    private String imageUrl;
}
