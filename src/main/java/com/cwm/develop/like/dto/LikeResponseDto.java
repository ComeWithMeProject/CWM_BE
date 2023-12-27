package com.cwm.develop.like.dto;

import com.cwm.develop.like.Like_TB;
import com.cwm.develop.openApi.areaBasedList1.AreaBasedList1;
import com.cwm.develop.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LikeResponseDto {

    private Long likeId;
    private User userId;
    private AreaBasedList1 areaBasedList1;

    public LikeResponseDto(Like_TB entity) {
        this.likeId = entity.getLikeId();
        this.userId = entity.getUserId();
        this.areaBasedList1 = entity.getAreaBasedList1Id();
    }
}
