package com.cwm.develop.openApi.areaBasedList1.repository;

import com.cwm.develop.openApi.areaBasedList1.AreaBasedList1;
import com.cwm.develop.openApi.areaBasedList1.dto.AreaInfoMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AreaBasedList1Repository extends JpaRepository<AreaBasedList1, Long> {

    Optional<AreaBasedList1> findById(Long id);

//    @Query(value = "select title, addr1 from AREABASEDLIST1 where title like %:keyword%",nativeQuery = true)
    List<AreaInfoMapping> findByTitleContaining(String keyword);
}
