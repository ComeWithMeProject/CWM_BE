package com.cwm.develop.openApi.detailIntro.repository;

import com.cwm.develop.openApi.detailIntro.entity.DetailIntro14;
import com.cwm.develop.openApi.detailIntro.entity.DetailIntro38;
import com.cwm.develop.openApi.detailIntro.entity.DetailIntro39;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DIRepository39 extends JpaRepository<DetailIntro39, Long> {

    //페이징 처리 통해 전체 목록 조회
    Page<DetailIntro39> findAll(Pageable pageable);
}
