package com.cwm.develop.openApi.detailIntro.service;

import com.cwm.develop.openApi.areaBasedList1.AreaBasedList1;
import com.cwm.develop.openApi.areaBasedList1.repository.AreaBasedList1Repository;
import com.cwm.develop.openApi.detailIntro.entity.*;
import com.cwm.develop.openApi.detailIntro.repository.*;
import com.cwm.develop.openApi.detailWithTour.DetailWithTour;
import com.cwm.develop.openApi.detailWithTour.repository.DWTRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DISerivce {

    private final AreaBasedList1Repository areaBasedList1Repository;
    private final DIRepository12 diRepository12;
    private final DIRepository14 diRepository14;
    private final DIRepository15 diRepository15;
    private final DIRepository28 diRepository28;
    private final DIRepository32 diRepository32;
    private final DIRepository38 diRepository38;
    private final DIRepository39 diRepository39;
    private final DWTRepository dwtRepository;

    @Transactional
    public String DetailView(String contentId, String contentTypeId) throws IOException {
        AreaBasedList1 areaBasedList1 = areaBasedList1Repository.findByContentId(contentId).get();
        String title = areaBasedList1.getTitle();
        String addr1 = areaBasedList1.getAddr1();
        String addr2 = areaBasedList1.getAddr2();

//        사용 시간 -> Detail Intro
//        전화번호 -> Detail Intro

        String usetime = "09:00 ~ 17:00";
        String tel = "02-3407-6531";

        switch (contentTypeId) {  // 입력 변수의 자료형은 byte, short, char, int, enum, String만 가능하다.
            case "12":  DetailIntro12 detailIntro12 = diRepository12.findByContentId(contentId).get();
                        usetime = detailIntro12.getUsetime();
                        tel = detailIntro12.getInfocenter();
                break;
            case "14":  DetailIntro14 detailIntro14 = diRepository14.findByContentId(contentId).get();
                        usetime = detailIntro14.getUsetimeculture();
                        tel = detailIntro14.getInfocenterculture();
                break;
            case "15":  DetailIntro15 detailIntro15 = diRepository15.findByContentId(contentId).get();
                        usetime = detailIntro15.getPlaytime();
                        tel = detailIntro15.getSponsor1tel();
                break;
            case "28":  DetailIntro28 detailIntro28 = diRepository28.findByContentId(contentId).get();
                        usetime = detailIntro28.getUsetimeleports();
                        tel = detailIntro28.getInfocenterleports();
                break;
            case "32":  DetailIntro32 detailIntro32 = diRepository32.findByContentId(contentId).get();
                        usetime = detailIntro32.getCheckintime() + " ~ " + detailIntro32.getCheckouttime();
                        tel = detailIntro32.getInfocenterlodging();
                break;
            case "38":  DetailIntro38 detailIntro38 = diRepository38.findByContentId(contentId).get();
                        usetime = detailIntro38.getOpentime();
                        tel = detailIntro38.getInfocentershopping();
                break;
            case "39":  DetailIntro39 detailIntro39 = diRepository39.findByContentId(contentId).get();
                        usetime = detailIntro39.getOpendatefood();
                        tel = detailIntro39.getInfocenterfood();
            default:
                break;
        }

//        장애인 주차 -> DetailWithTour
//        장애인 화장실 -> DetailWithTour
//        안내견 동반 -> DetailWithTour
//        유모차 대여 -> DetailWithTour

        DetailWithTour detailWithTour = dwtRepository.findByContentId(contentId).get();
        String parking = detailWithTour.getParking();
        String restroom = detailWithTour.getRestroom();
        String helpdog = detailWithTour.getHelpdog();
        String stroller = detailWithTour.getStroller();

        Map<String, Object> dataMap = new LinkedHashMap<>();
        dataMap.put("title", title);
        dataMap.put("addr1", addr1);
        dataMap.put("addr2", addr2);
        dataMap.put("usetime", usetime);
        dataMap.put("tel", tel);
        dataMap.put("parking", parking);
        dataMap.put("restroom", restroom);
        dataMap.put("helpdog", helpdog);
        dataMap.put("stroller", stroller);

        // ObjectMapper를 사용하여 JSON 문자열로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = objectMapper.writeValueAsString(dataMap);

        return jsonData;

//        String jsonData = String.format("{\"title\":%s, \"addr1\":%s, \"addr2\":%s, \"usetime\":%s, \"tel\":%s, \"parking\":%s, \"restroom\":%s, \"helpdog\":%s, \"stroller\":%s}",title,addr1,addr2,usetime,tel,parking,restroom,helpdog,stroller);
//        return jsonData;
    }

    @Transactional
    public void DetailIntroSave12() throws IOException {

        String result = "";
        int count = 0;

        try {

            for (int i=1; i<=282; i++){
                AreaBasedList1 areaBasedList1 = areaBasedList1Repository.findById((long) i).get();

                String contentId = areaBasedList1.getContentId();
                String contentTypeId = areaBasedList1.getContentTypeId();

                String urlStr = "http://apis.data.go.kr/B551011/KorWithService1/detailIntro1?serviceKey=jl9vw9yqOjADLHwfQ178BlRz4mGgsG5DcbGxIHfDY%2BAGYhtu3Aa3B26pj9R1dgXCnDb%2FxTnlNO%2BSB7txGF8qlA%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&contentId="
                +contentId+"&contentTypeId="+contentTypeId+"&_type=json";

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

                    DetailIntro12 detailIntro12 = new DetailIntro12(
                            (long) ++count,
                            (String) tmp.get("contentid"),
                            (String) tmp.get("contenttypeid"),
                            (String) tmp.get("heritage1"),
                            (String) tmp.get("heritage2"),
                            (String) tmp.get("heritage3"),
                            (String) tmp.get("infocenter"),
                            (String) tmp.get("opendate"),
                            (String) tmp.get("restdate"),
                            (String) tmp.get("expguide"),
                            (String) tmp.get("expagerange"),
                            (String) tmp.get("accomcount"),
                            (String) tmp.get("useseason"),
                            (String) tmp.get("usetime"),
                            (String) tmp.get("parking"),
                            (String) tmp.get("chkbabycarriage"),
                            (String) tmp.get("chkpet"),
                            (String) tmp.get("chkcreditcard")
                    );

                    diRepository12.save(detailIntro12);
                } // for(int i=0; i<array.size(); i++)
            }

        } catch (Exception e) {
            e.printStackTrace();
        } // catch
    } // public void DetailIntroSave()

    @Transactional
    public void DetailIntroSave14() throws IOException {

        String result = "";
        int count = 0;

        try {

            for (int i=283; i<=566; i++){
                AreaBasedList1 areaBasedList1 = areaBasedList1Repository.findById((long) i).get();

                String contentId = areaBasedList1.getContentId();
                String contentTypeId = areaBasedList1.getContentTypeId();

                String urlStr = "http://apis.data.go.kr/B551011/KorWithService1/detailIntro1?serviceKey=jl9vw9yqOjADLHwfQ178BlRz4mGgsG5DcbGxIHfDY%2BAGYhtu3Aa3B26pj9R1dgXCnDb%2FxTnlNO%2BSB7txGF8qlA%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&contentId="
                        +contentId+"&contentTypeId="+contentTypeId+"&_type=json";

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

                    DetailIntro14 detailIntro14 = new DetailIntro14(
                            (long) ++count,
                            (String) tmp.get("contentid"),
                            (String) tmp.get("contenttypeid"),
                            (String) tmp.get("scale"),
                            (String) tmp.get("usefee"),
                            (String) tmp.get("discountinfo"),
                            (String) tmp.get("spendtime"),
                            (String) tmp.get("parkingfee"),
                            (String) tmp.get("infocenterculture"),
                            (String) tmp.get("accomcountculture"),
                            (String) tmp.get("usetimeculture"),
                            (String) tmp.get("restdateculture"),
                            (String) tmp.get("parkingculture"),
                            (String) tmp.get("chkbabycarriageculture"),
                            (String) tmp.get("chkpetculture"),
                            (String) tmp.get("chkcreditcardculture")
                    );

                    diRepository14.save(detailIntro14);
                } // for(int i=0; i<array.size(); i++)
            }

        } catch (Exception e) {
            e.printStackTrace();
        } // catch
    } // public void DetailIntroSave()

    @Transactional
    public void DetailIntroSave15() throws IOException {

        String result = "";
        int count = 0;

        try {

            for (int i=567; i<=569; i++){
                AreaBasedList1 areaBasedList1 = areaBasedList1Repository.findById((long) i).get();

                String contentId = areaBasedList1.getContentId();
                String contentTypeId = areaBasedList1.getContentTypeId();

                String urlStr = "http://apis.data.go.kr/B551011/KorWithService1/detailIntro1?serviceKey=jl9vw9yqOjADLHwfQ178BlRz4mGgsG5DcbGxIHfDY%2BAGYhtu3Aa3B26pj9R1dgXCnDb%2FxTnlNO%2BSB7txGF8qlA%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&contentId="
                        +contentId+"&contentTypeId="+contentTypeId+"&_type=json";

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

                    DetailIntro15 detailIntro15 = new DetailIntro15(
                            (long) ++count,
                            (String) tmp.get("contentid"),
                            (String) tmp.get("contenttypeid"),
                            (String) tmp.get("sponsor1"),
                            (String) tmp.get("sponsor1tel"),
                            (String) tmp.get("sponsor2"),
                            (String) tmp.get("sponsor2tel"),
                            (String) tmp.get("eventenddate"),
                            (String) tmp.get("playtime"),
                            (String) tmp.get("eventplace"),
                            (String) tmp.get("eventhomepage"),
                            (String) tmp.get("agelimit"),
                            (String) tmp.get("bookingplace"),
                            (String) tmp.get("placeinfo"),
                            (String) tmp.get("subevent"),
                            (String) tmp.get("program"),
                            (String) tmp.get("eventstartdate"),
                            (String) tmp.get("usetimefestival"),
                            (String) tmp.get("discountinfofestival"),
                            (String) tmp.get("spendtimefestival"),
                            (String) tmp.get("festivalgrade")
                    );

                    diRepository15.save(detailIntro15);
                } // for(int i=0; i<array.size(); i++)
            }

        } catch (Exception e) {
            e.printStackTrace();
        } // catch
    } // public void DetailIntroSave()

    @Transactional
    public void DetailIntroSave28() throws IOException {

        String result = "";
        int count = 0;

        try {

            for (int i=570; i<=604; i++){
                AreaBasedList1 areaBasedList1 = areaBasedList1Repository.findById((long) i).get();

                String contentId = areaBasedList1.getContentId();
                String contentTypeId = areaBasedList1.getContentTypeId();

                String urlStr = "http://apis.data.go.kr/B551011/KorWithService1/detailIntro1?serviceKey=jl9vw9yqOjADLHwfQ178BlRz4mGgsG5DcbGxIHfDY%2BAGYhtu3Aa3B26pj9R1dgXCnDb%2FxTnlNO%2BSB7txGF8qlA%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&contentId="
                        +contentId+"&contentTypeId="+contentTypeId+"&_type=json";

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

                    DetailIntro28 detailIntro28 = new DetailIntro28(
                            (long) ++count,
                            (String) tmp.get("contentid"),
                            (String) tmp.get("contenttypeid"),
                            (String) tmp.get("openperiod"),
                            (String) tmp.get("reservation"),
                            (String) tmp.get("infocenterleports"),
                            (String) tmp.get("scaleleports"),
                            (String) tmp.get("accomcountleports"),
                            (String) tmp.get("restdateleports"),
                            (String) tmp.get("usetimeleports"),
                            (String) tmp.get("usefeeleports"),
                            (String) tmp.get("expagerangeleports"),
                            (String) tmp.get("parkingleports"),
                            (String) tmp.get("parkingfeeleports"),
                            (String) tmp.get("chkbabycarriageleports"),
                            (String) tmp.get("chkpetleports"),
                            (String) tmp.get("chkcreditcardleports")
                    );

                    diRepository28.save(detailIntro28);
                } // for(int i=0; i<array.size(); i++)
            }

        } catch (Exception e) {
            e.printStackTrace();
        } // catch
    } // public void DetailIntroSave()

    @Transactional
    public void DetailIntroSave32() throws IOException {

        String result = "";
        int count = 0;

        try {

            for (int i=605; i<=734; i++){
                AreaBasedList1 areaBasedList1 = areaBasedList1Repository.findById((long) i).get();

                String contentId = areaBasedList1.getContentId();
                String contentTypeId = areaBasedList1.getContentTypeId();

                String urlStr = "http://apis.data.go.kr/B551011/KorWithService1/detailIntro1?serviceKey=jl9vw9yqOjADLHwfQ178BlRz4mGgsG5DcbGxIHfDY%2BAGYhtu3Aa3B26pj9R1dgXCnDb%2FxTnlNO%2BSB7txGF8qlA%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&contentId="
                        +contentId+"&contentTypeId="+contentTypeId+"&_type=json";

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

                    DetailIntro32 detailIntro32 = new DetailIntro32(
                            (long) ++count,
                            (String) tmp.get("contentid"),
                            (String) tmp.get("contenttypeid"),
                            (String) tmp.get("goodstay"),
                            (String) tmp.get("benikia"),
                            (String) tmp.get("hanok"),
                            (String) tmp.get("roomcount"),
                            (String) tmp.get("roomtype"),
                            (String) tmp.get("refundregulation"),
                            (String) tmp.get("checkintime"),
                            (String) tmp.get("checkouttime"),
                            (String) tmp.get("chkcooking"),
                            (String) tmp.get("seminar"),
                            (String) tmp.get("sports"),
                            (String) tmp.get("sauna"),
                            (String) tmp.get("beauty"),
                            (String) tmp.get("beverage"),
                            (String) tmp.get("karaoke"),
                            (String) tmp.get("barbecue"),
                            (String) tmp.get("campfire"),
                            (String) tmp.get("bicycle"),
                            (String) tmp.get("fitness"),
                            (String) tmp.get("publicpc"),
                            (String) tmp.get("publicbath"),
                            (String) tmp.get("subfacility"),
                            (String) tmp.get("foodplace"),
                            (String) tmp.get("reservationurl"),
                            (String) tmp.get("pickup"),
                            (String) tmp.get("infocenterlodging"),
                            (String) tmp.get("parkinglodging"),
                            (String) tmp.get("reservationlodging"),
                            (String) tmp.get("scalelodging"),
                            (String) tmp.get("accomcountlodging")
                    );

                    diRepository32.save(detailIntro32);
                } // for(int i=0; i<array.size(); i++)
            }

        } catch (Exception e) {
            e.printStackTrace();
        } // catch
    } // public void DetailIntroSave()

    @Transactional
    public void DetailIntroSave38() throws IOException {

        String result = "";
        int count = 0;

        try {

            for (int i=735; i<=889; i++){
                AreaBasedList1 areaBasedList1 = areaBasedList1Repository.findById((long) i).get();

                String contentId = areaBasedList1.getContentId();
                String contentTypeId = areaBasedList1.getContentTypeId();

                String urlStr = "http://apis.data.go.kr/B551011/KorWithService1/detailIntro1?serviceKey=DkOIez19CK8KPQ7NAXAWmrxGloo6Dzw70qjMaDakfJIAQu3liUaNPQO83aGA9Om%2FGk%2FsIZEgyxY0H8sBp%2FLMfg%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&contentId="
                        +contentId+"&contentTypeId="+contentTypeId+"&_type=json";

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

                    DetailIntro38 detailIntro38 = new DetailIntro38(
                            (long) ++count,
                            (String) tmp.get("contentid"),
                            (String) tmp.get("contenttypeid"),
                            (String) tmp.get("saleitem"),
                            (String) tmp.get("saleitemcost"),
                            (String) tmp.get("fairday"),
                            (String) tmp.get("opendateshopping"),
                            (String) tmp.get("shopguide"),
                            (String) tmp.get("culturecenter"),
                            (String) tmp.get("restroom"),
                            (String) tmp.get("infocentershopping"),
                            (String) tmp.get("scaleshopping"),
                            (String) tmp.get("restdateshopping"),
                            (String) tmp.get("parkingshopping"),
                            (String) tmp.get("chkbabycarriageshopping"),
                            (String) tmp.get("chkpetshopping"),
                            (String) tmp.get("chkcreditcardshopping"),
                            (String) tmp.get("opentime")
                    );

                    diRepository38.save(detailIntro38);
                } // for(int i=0; i<array.size(); i++)
            }

        } catch (Exception e) {
            e.printStackTrace();
        } // catch
    } // public void DetailIntroSave()

    @Transactional
    public void DetailIntroSave39() throws IOException {

        String result = "";
        int count = 0;

        try {

            for (int i=890; i<=1125; i++){
                AreaBasedList1 areaBasedList1 = areaBasedList1Repository.findById((long) i).get();

                String contentId = areaBasedList1.getContentId();
                String contentTypeId = areaBasedList1.getContentTypeId();

                String urlStr = "http://apis.data.go.kr/B551011/KorWithService1/detailIntro1?serviceKey=DkOIez19CK8KPQ7NAXAWmrxGloo6Dzw70qjMaDakfJIAQu3liUaNPQO83aGA9Om%2FGk%2FsIZEgyxY0H8sBp%2FLMfg%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&contentId="
                        +contentId+"&contentTypeId="+contentTypeId+"&_type=json";

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

                    DetailIntro39 detailIntro39 = new DetailIntro39(
                            (long) ++count,
                            (String) tmp.get("contentid"),
                            (String) tmp.get("contenttypeid"),
                            (String) tmp.get("seat"),
                            (String) tmp.get("kidsfacility"),
                            (String) tmp.get("firstmenu"),
                            (String) tmp.get("treatmenu"),
                            (String) tmp.get("smoking"),
                            (String) tmp.get("packing"),
                            (String) tmp.get("infocenterfood"),
                            (String) tmp.get("scalefood"),
                            (String) tmp.get("parkingfood"),
                            (String) tmp.get("opendatefood"),
                            (String) tmp.get("opentimefood"),
                            (String) tmp.get("restdatefood"),
                            (String) tmp.get("discountinfofood"),
                            (String) tmp.get("chkcreditcardfood"),
                            (String) tmp.get("reservationfood"),
                            (String) tmp.get("lcnsno")
                    );

                    diRepository39.save(detailIntro39);
                } // for(int i=0; i<array.size(); i++)
            }

        } catch (Exception e) {
            e.printStackTrace();
        } // catch
    } // public void DetailIntroSave()

    //DetailIntro12 페이징 통한 전체 조회
    @Transactional
    public Page<DetailIntro12> getDetailIntro12(int page, int size) {
        return diRepository12.findAll(PageRequest.of(page,size, Sort.by("detailIntroId").descending()));
    }

    //DetailIntro14 페이징 통한 전체 조회
    @Transactional
    public Page<DetailIntro14> getDetailIntro14(int page, int size) {
        return diRepository14.findAll(PageRequest.of(page,size, Sort.by("detailIntroId").descending()));
    }

    //DetailIntro15 페이징 통한 전체 조회
    @Transactional
    public Page<DetailIntro15> getDetailIntro15(int page, int size) {
        return diRepository15.findAll(PageRequest.of(page,size, Sort.by("detailIntroId").descending()));
    }

    //DetailIntro28 페이징 통한 전체 조회
    @Transactional
    public Page<DetailIntro28> getDetailIntro28(int page, int size) {
        return diRepository28.findAll(PageRequest.of(page,size, Sort.by("detailIntroId").descending()));
    }

    //DetailIntro32 페이징 통한 전체 조회
    @Transactional
    public Page<DetailIntro32> getDetailIntro32(int page, int size) {
        return diRepository32.findAll(PageRequest.of(page,size, Sort.by("detailIntroId").descending()));
    }

    //DetailIntro38 페이징 통한 전체 조회
    @Transactional
    public Page<DetailIntro38> getDetailIntro38(int page, int size) {
        return diRepository38.findAll(PageRequest.of(page,size, Sort.by("detailIntroId").descending()));
    }

    //DetailIntro39 페이징 통한 전체 조회
    @Transactional
    public Page<DetailIntro39> getDetailIntro39(int page, int size) {
        return diRepository39.findAll(PageRequest.of(page,size, Sort.by("detailIntroId").descending()));
    }
}
