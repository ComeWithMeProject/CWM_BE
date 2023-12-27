package com.cwm.develop.openApi.areaCode1.dto;

import com.cwm.develop.openApi.areaCode1.AreaCode1;

public class AreaCode1ResponseDto {

    private Long rNum;
    private String code;
    private String name;

    public AreaCode1ResponseDto(AreaCode1 entity) {
        this.rNum = entity.getRNum();
        this.code = entity.getCode();
        this.name = entity.getName();
    }
}
