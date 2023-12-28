package com.cwm.develop.openApi.detailIntro.controller;

import com.cwm.develop.global.common.MultiResponseDto;
import com.cwm.develop.openApi.detailIntro.entity.*;
import com.cwm.develop.openApi.detailIntro.service.DISerivce;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
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
public class DIController {

    private final DISerivce diSerivce;

    @GetMapping("/detailView")
    public String detailView(@RequestParam(required = false, value = "contentId") String contentId,
                             @RequestParam(required = false, value = "contentTypeId") String contentTypeId) throws Exception {
        String jsonData = diSerivce.DetailView(contentId,contentTypeId);

        return jsonData;
    }

    @GetMapping("/detailIntro12")
    public String loadDetailIntro12() throws Exception {

        diSerivce.DetailIntroSave12();

        return "저장 성공";
    }

    @GetMapping("/detailIntro14")
    public String loadDetailIntro14() throws Exception {

        diSerivce.DetailIntroSave14();

        return "저장 성공";
    }

    @GetMapping("/detailIntro15")
    public String loadDetailIntro15() throws Exception {

        diSerivce.DetailIntroSave15();

        return "저장 성공";
    }

    @GetMapping("/detailIntro28")
    public String loadDetailIntro28() throws Exception {

        diSerivce.DetailIntroSave28();

        return "저장 성공";
    }

    @GetMapping("/detailIntro32")
    public String loadDetailIntro32() throws Exception {

        diSerivce.DetailIntroSave32();

        return "저장 성공";
    }

    @GetMapping("/detailIntro38")
    public String loadDetailIntro38() throws Exception {

        diSerivce.DetailIntroSave38();

        return "저장 성공";
    }

    @GetMapping("/detailIntro39")
    public String loadDetailIntro39() throws Exception {

        diSerivce.DetailIntroSave39();

        return "저장 성공";
    }

    //DetailIntro12 페이징 통한 전체 조회
    @GetMapping("/detailIntro12/lists")
    public ResponseEntity getDetailIntro12(@RequestParam(required = false, defaultValue = "0", value = "page") int page,
                                           @RequestParam(required = false, defaultValue = "0", value = "size") int size) {
        Page<DetailIntro12> result = diSerivce.getDetailIntro12(page -1, size);
        List<DetailIntro12> lists = result.getContent();

        return new ResponseEntity(new MultiResponseDto<>(lists, result), HttpStatus.OK);
    }

    //DetailIntro14 페이징 통한 전체 조회
    @GetMapping("/detailIntro14/lists")
    public ResponseEntity getDetailIntro14(@RequestParam(required = false, defaultValue = "0", value = "page") int page,
                                           @RequestParam(required = false, defaultValue = "0", value = "size") int size) {
        Page<DetailIntro14> result = diSerivce.getDetailIntro14(page -1, size);
        List<DetailIntro14> lists = result.getContent();

        return new ResponseEntity(new MultiResponseDto<>(lists, result), HttpStatus.OK);
    }

    //DetailIntro15 페이징 통한 전체 조회
    @GetMapping("/detailIntro15/lists")
    public ResponseEntity getDetailIntro15(@RequestParam(required = false, defaultValue = "0", value = "page") int page,
                                           @RequestParam(required = false, defaultValue = "0", value = "size") int size) {
        Page<DetailIntro15> result = diSerivce.getDetailIntro15(page -1, size);
        List<DetailIntro15> lists = result.getContent();

        return new ResponseEntity(new MultiResponseDto<>(lists, result), HttpStatus.OK);
    }

    //DetailIntro28 페이징 통한 전체 조회
    @GetMapping("/detailIntro28/lists")
    public ResponseEntity getDetailIntro28(@RequestParam(required = false, defaultValue = "0", value = "page") int page,
                                           @RequestParam(required = false, defaultValue = "0", value = "size") int size) {
        Page<DetailIntro28> result = diSerivce.getDetailIntro28(page -1, size);
        List<DetailIntro28> lists = result.getContent();

        return new ResponseEntity(new MultiResponseDto<>(lists, result), HttpStatus.OK);
    }

    //DetailIntro32 페이징 통한 전체 조회
    @GetMapping("/detailIntro32/lists")
    public ResponseEntity getDetailIntro32(@RequestParam(required = false, defaultValue = "0", value = "page") int page,
                                           @RequestParam(required = false, defaultValue = "0", value = "size") int size) {
        Page<DetailIntro32> result = diSerivce.getDetailIntro32(page -1, size);
        List<DetailIntro32> lists = result.getContent();

        return new ResponseEntity(new MultiResponseDto<>(lists, result), HttpStatus.OK);
    }

    //DetailIntro38 페이징 통한 전체 조회
    @GetMapping("/detailIntro38/lists")
    public ResponseEntity getDetailIntro38(@RequestParam(required = false, defaultValue = "0", value = "page") int page,
                                           @RequestParam(required = false, defaultValue = "0", value = "size") int size) {
        Page<DetailIntro38> result = diSerivce.getDetailIntro38(page -1, size);
        List<DetailIntro38> lists = result.getContent();

        return new ResponseEntity(new MultiResponseDto<>(lists, result), HttpStatus.OK);
    }

    //DetailIntro39 페이징 통한 전체 조회
    @GetMapping("/detailIntro39/lists")
    public ResponseEntity getDetailIntro39(@RequestParam(required = false, defaultValue = "0", value = "page") int page,
                                           @RequestParam(required = false, defaultValue = "0", value = "size") int size) {
        Page<DetailIntro39> result = diSerivce.getDetailIntro39(page -1, size);
        List<DetailIntro39> lists = result.getContent();

        return new ResponseEntity(new MultiResponseDto<>(lists, result), HttpStatus.OK);
    }
}
