package com.cwm.develop.openApi.areaCode1;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "AREACODE1")
public class AreaCode1 {

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

    public AreaCode1(Long rNum, String code, String name) {
        this.rNum = rNum;
        this.code = code;
        this.name = name;
    }
}
