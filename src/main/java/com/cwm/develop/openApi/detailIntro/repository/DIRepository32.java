package com.cwm.develop.openApi.detailIntro.repository;

import com.cwm.develop.openApi.detailIntro.entity.DetailIntro32;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DIRepository32 extends JpaRepository<DetailIntro32, Long> {
    //페이징 처리 통해 전체 목록 조회

    Optional<DetailIntro32> findByContentId(String contentId);
    Page<DetailIntro32> findAll(Pageable pageable);
}
