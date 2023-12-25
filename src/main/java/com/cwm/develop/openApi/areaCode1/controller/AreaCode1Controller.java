package com.cwm.develop.openApi.areaCode1.controller;

import com.cwm.develop.openApi.areaCode1.AreaCode1;
import com.cwm.develop.openApi.areaCode1.repository.AreaCode1Repository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AreaCode1Controller {

    private final AreaCode1Repository areaCode1Repository;

    @GetMapping("/areaCode1")
    public void areaCode1Save() throws IOException {

        String result = "";

        try {
            String urlStr = "https://apis.data.go.kr/B551011/KorWithService1/areaCode1?serviceKey=DkOIez19CK8KPQ7NAXAWmrxGloo6Dzw70qjMaDakfJIAQu3liUaNPQO83aGA9Om%2FGk%2FsIZEgyxY0H8sBp%2FLMfg%3D%3D&numOfRows=25&pageNo=1&MobileOS=ETC&MobileApp=AppTest&areaCode=1&_type=json";
            URL url = new URL(urlStr);
            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            result = br.readLine();

            //JSON 파싱 객체를 생성
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
            //response를 받아옴
            JSONObject parseResponse = (JSONObject) jsonObject.get("response");
            //parseResponse에는 response 내부의 데이터들이 들어있음

            //body를 받아옴
            JSONObject parseBody = (JSONObject) parseResponse.get("body");
            //parseBody에는 body 내부의 데이터들이 들어있음

            //Items를 받아옴
            JSONObject parseItems = (JSONObject) parseBody.get("items");
            //parseItems에는 items 내부의 데이터들이 들어있음

            //item 안쪽의 데이터는 [] 즉 배열의 형태이기에 제이슨 배열로 받아온다.
            JSONArray array = (JSONArray) parseItems.get("item");

            for(int i=0; i<array.size(); i++) {
                JSONObject tmp = (JSONObject)array.get(i);
                AreaCode1 areaCode1 = new AreaCode1(
                        (long)tmp.get("rnum"),
                        (String)tmp.get("code"),
                        (String)tmp.get("name"));
                areaCode1Repository.save(areaCode1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
