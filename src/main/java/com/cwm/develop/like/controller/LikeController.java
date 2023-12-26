package com.cwm.develop.like.controller;

import com.cwm.develop.like.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/like")
public class LikeController {

    private final LikeService likeService;

    // user 정보 가져와서 userId와 장소Id 넣기, 그리고 세이브


}
