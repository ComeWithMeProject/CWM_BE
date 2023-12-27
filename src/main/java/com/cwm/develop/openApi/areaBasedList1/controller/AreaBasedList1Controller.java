package com.cwm.develop.openApi.areaBasedList1.controller;

import com.cwm.develop.global.common.MultiResponseDto;
import com.cwm.develop.openApi.areaBasedList1.AreaBasedList1;
import com.cwm.develop.openApi.areaBasedList1.dto.AreaBasedList1Dto;
import com.cwm.develop.openApi.areaBasedList1.mapping.AreaBasedList1Mapping;
import com.cwm.develop.openApi.areaBasedList1.repository.AreaBasedList1Repository;
import com.cwm.develop.openApi.areaBasedList1.service.AreaBasedListService;
import com.cwm.develop.openApi.areaCode1.AreaCode1;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
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

    @GetMapping("/areaBasedList1/lists")
    public ResponseEntity getAreaBasedList1lists(@RequestParam(required = false, defaultValue = "0", value = "page") int page,
                                                 @RequestParam(required = false, defaultValue = "0", value = "size") int size) {
        Page<AreaBasedList1> result = areaBasedListService.getAreaBasedList1lists(page -1, size);
        List<AreaBasedList1> lists = result.getContent();

        return new ResponseEntity(new MultiResponseDto<>(lists, result), HttpStatus.OK);
    }
}
