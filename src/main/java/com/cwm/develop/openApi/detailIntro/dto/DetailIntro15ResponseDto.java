package com.cwm.develop.openApi.detailIntro.dto;

import com.cwm.develop.openApi.detailIntro.entity.DetailIntro15;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DetailIntro15ResponseDto {

    private Long detailIntroId;

    //contentid
    private String contentId;

    //contenttypeid
    private String contenttypeid;

    private String sponsor1;

    private String sponsor1tel;

    private String sponsor2;

    private String sponsor2tel;

    private String eventenddate;

    private String playtime;

    private String eventplace;

    private String eventhomepage;

    private String agelimit;

    private String bookingplace;

    private String placeinfo;

    private String subevent;

    private String program;

    private String eventstartdate;

    private String usetimefestival;

    private String discountinfofestival;

    private String spendtimefestival;

    private String festivalgrade;

    public DetailIntro15ResponseDto(DetailIntro15 entity) {
        this.detailIntroId = entity.getDetailIntroId();
        this.contentId = entity.getContentId();
        this.contenttypeid = entity.getContenttypeid();
        this.sponsor1 = entity.getSponsor1();
        this.sponsor1tel = entity.getSponsor1tel();
        this.sponsor2 = entity.getSponsor2();
        this.sponsor2tel = entity.getSponsor2tel();
        this.eventenddate = entity.getEventenddate();
        this.playtime = entity.getPlaytime();
        this.eventplace = entity.getEventplace();
        this.eventhomepage = entity.getEventhomepage();
        this.agelimit = entity.getAgelimit();
        this.bookingplace = entity.getBookingplace();
        this.placeinfo = entity.getPlaceinfo();
        this.subevent = entity.getSubevent();
        this.program = entity.getProgram();
        this.eventstartdate = entity.getEventstartdate();
        this.usetimefestival = entity.getUsetimefestival();
        this.discountinfofestival = entity.getDiscountinfofestival();
        this.spendtimefestival = entity.getSpendtimefestival();
        this.festivalgrade = entity.getFestivalgrade();
    }
}
