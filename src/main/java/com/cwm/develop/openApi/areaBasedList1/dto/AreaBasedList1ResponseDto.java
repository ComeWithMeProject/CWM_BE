package com.cwm.develop.openApi.areaBasedList1.dto;

import com.cwm.develop.openApi.areaBasedList1.AreaBasedList1;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AreaBasedList1ResponseDto {

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

    public AreaBasedList1ResponseDto(AreaBasedList1 entity) {
        this.areaBasedListId = entity.getAreaBasedListId();
        this.addr1 = entity.getAddr1();
        this.addr2 = entity.getAddr2();
        this.areaCode = entity.getAreaCode();
        this.bookTour = entity.getBookTour();
        this.cat1 = entity.getCat1();
        this.cat2 = entity.getCat2();
        this.cat3 = entity.getCat3();
        this.contentId = entity.getContentId();
        this.contentTypeId = entity.getContentTypeId();
        this.createdTime = entity.getCreatedTime();
        this.firstImage = entity.getFirstImage();
        this.firstImage2 = entity.getFirstImage2();
        this.cpyrhtDivCd = entity.getCpyrhtDivCd();
        this.mapx = entity.getMapx();
        this.mapy = entity.getMapy();
        this.mlevel = entity.getMlevel();
        this.modifiedTime = entity.getModifiedTime();
        this.sigunguCode = entity.getSigunguCode();
        this.tel = entity.getTel();
        this.title = entity.getTitle();
        this.zipCode = entity.getZipCode();
    }
}
