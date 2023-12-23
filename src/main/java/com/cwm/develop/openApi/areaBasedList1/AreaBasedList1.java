package com.cwm.develop.openApi.areaBasedList1;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "AREABASEDLIST1")
public class AreaBasedList1 {

    //areaBasedListId
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "areaBasedListId")
    private Long areaBasedListId;

    //addr1
    private String addr1;

    //addr2
    private String addr2;

    //areacode
    private String areaCode;

    //booktour
    private String bookTour;

    //cat1(대분류)
    private String cat1;

    //cat2(중분류)
    private String cat2;

    //cat3(소분류)
    private String cat3;

    //contentid
    private String contentId;

    //contenttypeid
    private String contentTypeId;

    //createdtime
    private String createdTime;

    //firstimage
    private String firstImage;

    //firstimage2
    private String firstImage2;

    //cpyrhtDivCd
    private String cpyrhtDivCd;

    //mapx
    private String mapx;

    //mapy
    private String mapy;

    //mlevel
    private String mlevel;

    //modifiedtime
    private String modifiedTime;

    //sigungucode
    private String sigunguCode;

    //tel
    private String tel;

    //title
    private String title;

    //zipcode
    private String zipCode;

    public AreaBasedList1(Long areaBasedListId, String addr1, String addr2, String areaCode, String bookTour,
                          String cat1, String cat2, String cat3, String contentId, String contentTypeId,
                          String createdTime, String firstImage, String firstImage2, String cpyrhtDivCd,
                          String mapx, String mapy, String mlevel, String modifiedTime, String sigunguCode,
                          String tel, String title, String zipCode) {
        this.areaBasedListId = areaBasedListId;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.areaCode = areaCode;
        this.bookTour = bookTour;
        this.cat1 = cat1;
        this.cat2 = cat2;
        this.cat3 = cat3;
        this.contentId = contentId;
        this.contentTypeId = contentTypeId;
        this.createdTime = createdTime;
        this.firstImage = firstImage;
        this.firstImage2 = firstImage2;
        this.cpyrhtDivCd = cpyrhtDivCd;
        this.mapx = mapx;
        this.mapy = mapy;
        this.mlevel = mlevel;
        this.modifiedTime = modifiedTime;
        this.sigunguCode = sigunguCode;
        this.tel = tel;
        this.title = title;
        this.zipCode = zipCode;
    }
}