package com.cwm.develop.like.controller;

import com.cwm.develop.like.dto.LikeRequestDto;
import com.cwm.develop.like.dto.LikeResponseDto;
import com.cwm.develop.like.dto.LikeSuccessResponse;
import com.cwm.develop.like.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/like")
public class LikeController {

    private final LikeService likeService;

    //like 생성
    @PostMapping("/item")
    public LikeResponseDto createLike(@RequestBody LikeRequestDto requestDto) {
        return likeService.createLike(requestDto);
    }

    //선택한 like 삭제
    @DeleteMapping("/item/{id}")
    public LikeSuccessResponse deleteLike(@PathVariable Long id) throws Exception {
        return likeService.deleteLike(id);
    }

}
