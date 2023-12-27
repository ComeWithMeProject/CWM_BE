package com.cwm.develop.openApi.areaBasedList1.repository;

import com.cwm.develop.openApi.areaBasedList1.AreaBasedList1;
import com.cwm.develop.openApi.areaBasedList1.mapping.AreaBasedList1Mapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AreaBasedList1Repository extends JpaRepository<AreaBasedList1, Long> {

    Optional<AreaBasedList1> findById(Long id);

    //페이징 처리 통해 전체 목록 조회
    Page<AreaBasedList1> findAll(Pageable pageable);
}
