package com.cwm.develop.like.dto;

import com.cwm.develop.openApi.areaBasedList1.AreaBasedList1;
import com.cwm.develop.user.User;
import lombok.Getter;

@Getter
public class LikeRequestDto {

    private User userId;
    private AreaBasedList1 areaBasedList1;

}
