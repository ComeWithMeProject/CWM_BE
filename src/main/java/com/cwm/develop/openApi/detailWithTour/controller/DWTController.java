package com.cwm.develop.openApi.detailWithTour.controller;

import com.cwm.develop.openApi.detailWithTour.service.DWTService1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
