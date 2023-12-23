package com.cwm.develop.openApi.detailWithTour.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DetailWithTourController {

    @GetMapping("/detailWithTour")
    public String loadDetailWithTour() throws Exception {
        String[] contentIdArray = new String[]{"232229","130577","129917","130278","1604784","133854","2606224","126512","2543919","775394"};
        StringBuilder result = new StringBuilder();
        for(String str : contentIdArray) {


                String urlStr = "http://apis.data.go.kr/B551011/KorWithService1/detailWithTour1?" +
                        "serviceKey=DkOIez19CK8KPQ7NAXAWmrxGloo6Dzw70qjMaDakfJIAQu3liUaNPQO83aGA9Om%2FGk%2FsIZEgyxY0H8sBp%2FLMfg%3D%3D" +
                        "&numOfRows=1" +
                        "&pageNo=1" +
                        "&MobileOS=ETC" +
                        "&MobileApp=AppTest" +
                        "&contentId=" + str +
                        "&_type=json";

                 URL url = new URL(urlStr);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader br;

            br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

            String returnLine;

            while ((returnLine = br.readLine()) != null) {
                result.append(returnLine+"\n\r");
            }

            urlConnection.disconnect();
        }
        return result.toString();
    }
}
