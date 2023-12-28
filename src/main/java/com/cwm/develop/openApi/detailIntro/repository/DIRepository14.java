package com.cwm.develop.openApi.detailIntro.repository;

import com.cwm.develop.openApi.detailIntro.entity.DetailIntro14;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DIRepository14 extends JpaRepository<DetailIntro14, Long> {
    //페이징 처리 통해 전체 목록 조회
    Page<DetailIntro14> findAll(Pageable pageable);
    Optional<DetailIntro14> findByContentId(String contentId);
}
