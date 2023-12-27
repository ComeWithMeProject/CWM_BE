package com.cwm.develop.openApi.detailWithTour.repository;

import com.cwm.develop.openApi.areaBasedList1.AreaBasedList1;
import com.cwm.develop.openApi.detailWithTour.DetailWithTour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DWTRepository extends JpaRepository<DetailWithTour, Long> {

    Optional<DetailWithTour> findById(Long id);

    //페이징 처리 통해 전체 목록 조회
    Page<DetailWithTour> findAll(Pageable pageable);
}
