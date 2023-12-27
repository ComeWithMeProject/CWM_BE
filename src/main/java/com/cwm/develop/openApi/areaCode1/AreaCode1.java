package com.cwm.develop.openApi.areaCode1;

import com.cwm.develop.openApi.areaCode1.dto.AreaCode1RequestDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import javax.persistence.*;

@Entity
@Data
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "AREACODE1")
public class AreaCode1 {

//    @Id
//    @Column(name = "areaCode1Id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long areaCode1Id;

    //rnum
    @Id
    @Column(name = "rNum")
    private Long rNum;

    //code
    @Column(name = "code")
    private String code;

    //서울시 구 이름
    @Column(name = "name")
    private String name;

    public AreaCode1(/*Long areaCode1Id,*/ Long rNum, String code, String name) {
        //this.areaCode1Id = areaCode1Id;
        this.rNum = rNum;
        this.code = code;
        this.name = name;
    }

    public AreaCode1(AreaCode1RequestDto requestDto) {
        this.rNum = requestDto.getRNum();
        this.code = requestDto.getCode();
        this.name = requestDto.getName();
    }

}
