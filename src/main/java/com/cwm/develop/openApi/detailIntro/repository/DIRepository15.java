package com.cwm.develop.openApi.detailIntro.repository;

import com.cwm.develop.openApi.detailIntro.entity.DetailIntro15;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DIRepository15 extends JpaRepository<DetailIntro15, Long> {
    //페이징 처리 통해 전체 목록 조회
    Page<DetailIntro15> findAll(Pageable pageable);

    Optional<DetailIntro15> findByContentId(String contentId);
}
