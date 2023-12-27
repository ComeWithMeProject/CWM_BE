package com.cwm.develop.openApi.areaCode1.service;

import com.cwm.develop.openApi.areaCode1.AreaCode1;
import com.cwm.develop.openApi.areaCode1.repository.AreaCode1Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AreaCode1Service {

    private final AreaCode1Repository areaCode1Repository;

    //페이징 처리해 전체 조회
    @Transactional
    public Page<AreaCode1> getAreaCode1lists(int page, int size) {
        return areaCode1Repository.findAll(PageRequest.of(page,size, Sort.by("rNum").descending()));
    }
}
