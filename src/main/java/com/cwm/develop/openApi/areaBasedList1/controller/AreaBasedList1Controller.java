package com.cwm.develop.openApi.areaBasedList1.controller;

import com.cwm.develop.global.common.MultiResponseDto;
import com.cwm.develop.openApi.areaBasedList1.AreaBasedList1;
import com.cwm.develop.openApi.areaBasedList1.dto.AreaInfoMapping;
import com.cwm.develop.openApi.areaBasedList1.service.AreaBasedListService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.awt.geom.Area;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AreaBasedList1Controller {

    private final AreaBasedListService areaBasedListService;

    @GetMapping("/areaBasedList1")
    public String saveAreaBasedList1() throws Exception {
        areaBasedListService.areaBasedList1Save();
        return "저장 성공";
    }

    //전체 목록 조회
    @GetMapping("/areaBasedList1/lists")
    public ResponseEntity getAreaBasedList1lists(@RequestParam(required = false, defaultValue = "0", value = "page") int page,
                                                 @RequestParam(required = false, defaultValue = "0", value = "size") int size) {
        Page<AreaBasedList1> result = areaBasedListService.getAreaBasedList1lists(page -1, size);
        List<AreaBasedList1> lists = result.getContent();

        return new ResponseEntity(new MultiResponseDto<>(lists, result), HttpStatus.OK);
    }

    //검색 + 페이징 (검색페이지)
    @GetMapping("/areaBasedList1/search")
    public ResponseEntity searchAreaBasedList1Title(@RequestParam(value ="title",required = false) String title,
                                                   @RequestParam @Positive int page,
                                                   @RequestParam @Positive int size) {
        Page<AreaBasedList1> result = areaBasedListService.searchTitle(title, page, size);
        List<AreaBasedList1> lists = result.getContent();

        return new ResponseEntity(new MultiResponseDto<>(lists, result), HttpStatus.OK);
    }

    //검색 + 페이징 (메인페이지)
    @GetMapping("/areaBasedList1/main/search")
    public ResponseEntity searchAreaBasedList1Main(@RequestParam(value ="areaCode",required = false) String areaCode,
                                                   @RequestParam(value = "contentTypeId", required = false) String contentTypeId,
                                                   @RequestParam @Positive int page,
                                                   @RequestParam @Positive int size) {
        Page<AreaBasedList1> result = areaBasedListService.searchAreaCodeAndContentTypeId(areaCode, contentTypeId, page, size);
        List<AreaBasedList1> lists = result.getContent();

        return new ResponseEntity(new MultiResponseDto<>(lists, result), HttpStatus.OK);
    }

}
