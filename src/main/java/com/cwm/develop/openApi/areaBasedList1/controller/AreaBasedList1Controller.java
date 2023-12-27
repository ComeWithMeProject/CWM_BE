package com.cwm.develop.openApi.areaBasedList1.controller;

import com.cwm.develop.openApi.areaBasedList1.AreaBasedList1;
import com.cwm.develop.openApi.areaBasedList1.dto.AreaInfoMapping;
import com.cwm.develop.openApi.areaBasedList1.service.AreaBasedListService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
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

//    @GetMapping("/areaBasedList1/search")
//    public List<AreaInfoMapping> search(String keyword) {
//
//        List<AreaInfoMapping> list = areaBasedListService.search(keyword);
//        System.out.println("리스트 : " + list);
//
//        String json = new Gson().toJson(list);
//        System.out.println("제이슨 결과 = " + json);
//        return areaBasedListService.search(keyword);
//    }

}
