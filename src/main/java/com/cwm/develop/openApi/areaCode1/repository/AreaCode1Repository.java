package com.cwm.develop.openApi.areaCode1.repository;

import com.cwm.develop.openApi.areaCode1.AreaCode1;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaCode1Repository extends JpaRepository<AreaCode1, Long> {

    //페이징 처리를 통한 전체 목록 조회
    Page<AreaCode1> findAll(Pageable pageable);

}
