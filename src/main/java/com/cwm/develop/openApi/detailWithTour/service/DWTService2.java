package com.cwm.develop.openApi.detailWithTour.service;

import com.cwm.develop.openApi.areaBasedList1.AreaBasedList1;
import com.cwm.develop.openApi.areaBasedList1.repository.AreaBasedList1Repository;
import com.cwm.develop.openApi.detailWithTour.repository.DWTRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DWTService2 {

    private final DWTRepository dwtRepository;
    private final AreaBasedList1Repository areaBasedList1Repository;

    @Transactional
    public String DetailWithTourSave() throws IOException {
        try {

            StringBuilder result = new StringBuilder();

            for (int i=1; i<=24; i++){
                AreaBasedList1 areaBasedList1 = areaBasedList1Repository.findById((long) i).get();

                String contentId = areaBasedList1.getContentId();



                String urlStr = "http://apis.data.go.kr/B551011/KorWithService1/detailWithTour1?" +
                        "serviceKey=DkOIez19CK8KPQ7NAXAWmrxGloo6Dzw70qjMaDakfJIAQu3liUaNPQO83aGA9Om%2FGk%2FsIZEgyxY0H8sBp%2FLMfg%3D%3D" +
                        "&numOfRows=1" +
                        "&pageNo=1" +
                        "&MobileOS=ETC" +
                        "&MobileApp=AppTest" +
                        "&contentId=" + contentId +
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

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
