package com.cwm.develop.like.dto;

import lombok.Getter;

@Getter
public class LikeSuccessResponse {
    private boolean success;

    public LikeSuccessResponse(boolean success) {
        this.success = success;
    }
}
