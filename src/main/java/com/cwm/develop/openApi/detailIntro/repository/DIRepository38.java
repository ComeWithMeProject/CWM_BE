package com.cwm.develop.openApi.detailIntro.repository;

import com.cwm.develop.openApi.detailIntro.entity.DetailIntro38;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DIRepository38 extends JpaRepository<DetailIntro38, Long> {
    //페이징 처리 통해 전체 목록 조회

    Optional<DetailIntro38> findByContentId(String contentId);
    Page<DetailIntro38> findAll(Pageable pageable);
}
