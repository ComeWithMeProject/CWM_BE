package com.cwm.develop.openApi.detailWithTour.controller;

import com.cwm.develop.global.common.MultiResponseDto;
import com.cwm.develop.openApi.detailWithTour.DetailWithTour;
import com.cwm.develop.openApi.detailWithTour.service.DWTService1;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DWTController {

    private final DWTService1 dwtService;

    @GetMapping("/detailWithTour")
    public String loadDetailWithTour() throws Exception {

        dwtService.DetailWithTourSave();

        return "저장 성공";
    }

    @GetMapping("/detailWithTour/lists")
    public ResponseEntity getDetailWithTourLists(@RequestParam(required = false, defaultValue = "0", value = "page") int page,
                                                 @RequestParam(required = false, defaultValue = "0", value = "size") int size) {
        Page<DetailWithTour> result = dwtService.getDetailWithTourLists(page -1, size);
        List<DetailWithTour> lists = result.getContent();

        return new ResponseEntity(new MultiResponseDto<>(lists, result), HttpStatus.OK);
    }
}
