package com.cwm.develop.openApi.detailWithTour.service;

import com.cwm.develop.openApi.areaBasedList1.AreaBasedList1;
import com.cwm.develop.openApi.areaBasedList1.repository.AreaBasedList1Repository;
import com.cwm.develop.openApi.detailWithTour.DetailWithTour;
import com.cwm.develop.openApi.detailWithTour.repository.DWTRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DWTService1 {

    private final DWTRepository dwtRepository;
    private final AreaBasedList1Repository areaBasedList1Repository;

    @Transactional
    public void DetailWithTourSave() throws IOException {

        String result = "";
        int count = 0;

        try {

            for (int i=1121; i<=1125; i++){
                AreaBasedList1 areaBasedList1 = areaBasedList1Repository.findById((long) i).get();

                String contentId = areaBasedList1.getContentId();

                String urlStr = "http://apis.data.go.kr/B551011/KorWithService1/detailWithTour1?" +
                        "serviceKey=jl9vw9yqOjADLHwfQ178BlRz4mGgsG5DcbGxIHfDY%2BAGYhtu3Aa3B26pj9R1dgXCnDb%2FxTnlNO%2BSB7txGF8qlA%3D%3D" +
                        "&numOfRows=100" +
                        "&pageNo=1" +
                        "&MobileOS=ETC" +
                        "&MobileApp=AppTest" +
                        "&contentId=" + contentId +
                        "&_type=json";

                URL url = new URL(urlStr);
                BufferedReader br;
                br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

                result = br.readLine();

                System.out.println("result : " + result);


                //JSON 파싱 객체를 생성
                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(result);


                //response를 받아옴
                JSONObject parseResponse = (JSONObject) jsonObject.get("response");
                //parseResponse에는 response 내부의 데이터들이 들어있음

                //body를 받아옴
                JSONObject parseBody = (JSONObject) parseResponse.get("body");
                //parseBody에는 body 내부의 데이터들이 들어있음



                if (parseBody.get("items").equals("")) {
                    continue;
                }

                //Items를 받아옴
                JSONObject parseItems = (JSONObject) parseBody.get("items");
                //parseItems에는 items 내부의 데이터들이 들어있음

                //item 안쪽의 데이터는 [] 즉 배열의 형태이기에 제이슨 배열로 받아온다.
                JSONArray array = (JSONArray) parseItems.get("item");

                for(int j=0; j<array.size(); j++) {
                    JSONObject tmp = (JSONObject)array.get(j);

                    DetailWithTour detailWithTour = new DetailWithTour(
                            (long) ++count+1120,
                            (String) tmp.get("contentid"),
                            (String) tmp.get("parking"),
                            (String) tmp.get("route"),
                            (String) tmp.get("publictransport"),
                            (String) tmp.get("ticketoffice"),
                            (String) tmp.get("promotion"),
                            (String) tmp.get("wheelchair"),
                            (String) tmp.get("exit"),
                            (String) tmp.get("elevator"),
                            (String) tmp.get("restroom"),
                            (String) tmp.get("auditorium"),
                            (String) tmp.get("room"),
                            (String) tmp.get("handicapetc"),
                            (String) tmp.get("braileblock"),
                            (String) tmp.get("helpdog"),
                            (String) tmp.get("guidehuman"),
                            (String) tmp.get("audioguide"),
                            (String) tmp.get("bigprint"),
                            (String) tmp.get("brailepromotion"),
                            (String) tmp.get("guidesystem"),
                            (String) tmp.get("blindhandicapetc"),
                            (String) tmp.get("signguide"),
                            (String) tmp.get("videoguide"),
                            (String) tmp.get("hearingroom"),
                            (String) tmp.get("hearinghandicapetc"),
                            (String) tmp.get("stroller"),
                            (String) tmp.get("lactationroom"),
                            (String) tmp.get("babysparechair"),
                            (String) tmp.get("infantsfamilyetc")
                    );

                    dwtRepository.save(detailWithTour);
                } // for(int i=0; i<array.size(); i++)
            } // for (int i=1; i<=24; i++)

        } catch (Exception e) {
                e.printStackTrace();
        } // catch
    } // public void DetailWithTourSave1()

    @Transactional
    public Page<DetailWithTour> getDetailWithTourLists(int page, int size) {
        return dwtRepository.findAll(PageRequest.of(page,size, Sort.by("detailWithTourId").descending()));
    }
}
