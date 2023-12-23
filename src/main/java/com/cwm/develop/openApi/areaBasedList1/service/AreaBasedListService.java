package com.cwm.develop.openApi.areaBasedList1.service;

import com.cwm.develop.openApi.areaBasedList1.AreaBasedList1;
import com.cwm.develop.openApi.areaBasedList1.repository.AreaBasedList1Repository;
import com.cwm.develop.openApi.areaCode1.AreaCode1;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AreaBasedListService {

    private final AreaBasedList1Repository areaBasedList1Repository;

    @Transactional
    public void areaBasedList1Save() throws IOException {

        String result = "";

        try {
            String urlStr = "https://apis.data.go.kr/B551011/KorWithService1/areaBasedList1?serviceKey=jl9vw9yqOjADLHwfQ178BlRz4mGgsG5DcbGxIHfDY%2BAGYhtu3Aa3B26pj9R1dgXCnDb%2FxTnlNO%2BSB7txGF8qlA%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&listYN=Y&arrange=C&_type=json&contentTypeId=39&areaCode=1&sigunguCode=25";
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
                AreaBasedList1 areaBasedList1 = new AreaBasedList1(
                        i+(long)494,
                        (String) tmp.get("addr1"),
                        (String) tmp.get("addr2"),
                        (String) tmp.get("areacode"),
                        (String) tmp.get("booktour"),
                        (String) tmp.get("cat1"),
                        (String) tmp.get("cat2"),
                        (String) tmp.get("cat3"),
                        (String) tmp.get("contentid"),
                        (String) tmp.get("contenttypeid"),
                        (String) tmp.get("createdtime"),
                        (String) tmp.get("firstimage"),
                        (String) tmp.get("firstimage2"),
                        (String) tmp.get("cpyrhtDivCd"),
                        (String) tmp.get("mapx"),
                        (String) tmp.get("mapy"),
                        (String) tmp.get("mlevel"),
                        (String) tmp.get("modifiedtime"),
                        (String) tmp.get("sigungucode"),
                        (String) tmp.get("tel"),
                        (String) tmp.get("title"),
                        (String) tmp.get("zipcode")
                );
                areaBasedList1Repository.save(areaBasedList1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
