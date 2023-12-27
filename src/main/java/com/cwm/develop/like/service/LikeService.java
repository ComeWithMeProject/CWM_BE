package com.cwm.develop.like.service;

import com.cwm.develop.like.Like_TB;
import com.cwm.develop.like.dto.LikeRequestDto;
import com.cwm.develop.like.dto.LikeResponseDto;
import com.cwm.develop.like.dto.LikeSuccessResponse;
import com.cwm.develop.like.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;

    //like 생성
    @Transactional
    public LikeResponseDto createLike(LikeRequestDto requestDto) {
        Like_TB like_tb = new Like_TB(requestDto);
        likeRepository.save(like_tb);
        return new LikeResponseDto(like_tb);
    }

    //선택한 like 삭제
    @Transactional
    public LikeSuccessResponse deleteLike(Long likeId) throws Exception {
        Like_TB like_tb = likeRepository.findById(likeId).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다."));

        likeRepository.deleteById(likeId);
        return new LikeSuccessResponse(true);
    }
}
