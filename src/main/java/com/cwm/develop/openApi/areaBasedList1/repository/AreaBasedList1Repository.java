package com.cwm.develop.openApi.areaBasedList1.repository;

import com.cwm.develop.openApi.areaBasedList1.AreaBasedList1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AreaBasedList1Repository extends JpaRepository<AreaBasedList1, Long> {

    Optional<AreaBasedList1> findById(Long id);
}
