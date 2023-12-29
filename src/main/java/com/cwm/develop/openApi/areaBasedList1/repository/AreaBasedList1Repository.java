package com.cwm.develop.openApi.areaBasedList1.repository;

import com.cwm.develop.openApi.areaBasedList1.AreaBasedList1;
import com.cwm.develop.openApi.areaBasedList1.dto.AreaInfoMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AreaBasedList1Repository extends JpaRepository<AreaBasedList1, Long> {

    Optional<AreaBasedList1> findById(Long id);

    Optional<AreaBasedList1> findByContentId(String contentId);

    //페이징 처리 통해 전체 목록 조회
    Page<AreaBasedList1> findAll(Pageable pageable);

    //검색 + 페이징 (검색페이지)
    Page<AreaBasedList1> findByTitleAndContentTypeIdContains(String title, String contentTypeId, Pageable pageable);

    //검색 + 페이징 (메인페이지)
    Page<AreaBasedList1> findByAreaCodeAndContentTypeIdContains(String sigunguCode, String contentTypeId, Pageable pageable);
}
