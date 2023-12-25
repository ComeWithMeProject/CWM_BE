package com.cwm.develop.openApi.detailIntro.controller;

import com.cwm.develop.openApi.detailIntro.service.DISerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DIController {

    private final DISerivce diSerivce;

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
}
