package com.cwm.develop.openApi.detailWithTour.dto;

import com.cwm.develop.openApi.detailWithTour.DetailWithTour;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DetailWithTourResponseDto {

    private Long detailWithTourId;
    private String contentId;
    private String parking;
    private String route;
    private String publictransport;
    private String ticketoffice;
    private String promotion;
    private String wheelchair;
    private String exit;
    private String elevator;
    private String restroom;
    private String auditorium;
    private String room;
    private String handicapetc;
    private String braileblock;
    private String helpdog;
    private String guidehuman;
    private String audioguide;
    private String bigprint;
    private String brailepromotion;
    private String guidesystem;
    private String blindhandicapetc;
    private String signguide;
    private String videoguide;
    private String hearingroom;
    private String hearinghandicapetc;
    private String stroller;
    private String lactationroom;
    private String babysparechair;
    private String infantsfamilyetc;

    public DetailWithTourResponseDto(DetailWithTour entity) {
        this.detailWithTourId = entity.getDetailWithTourId();
        this.contentId = entity.getContentId();
        this.parking = entity.getParking();
        this.route = entity.getRoute();
        this.publictransport = entity.getPublictransport();
        this.ticketoffice = entity.getTicketoffice();
        this.promotion = entity.getPromotion();
        this.wheelchair = entity.getWheelchair();
        this.exit = entity.getExit();
        this.elevator = entity.getElevator();
        this.restroom = entity.getRestroom();
        this.auditorium = entity.getAuditorium();
        this.room = entity.getRoom();
        this.handicapetc = entity.getHandicapetc();
        this.braileblock = entity.getBraileblock();
        this.helpdog = entity.getHelpdog();
        this.guidehuman = entity.getGuidehuman();
        this.audioguide = entity.getAudioguide();
        this.bigprint = entity.getBigprint();
        this.brailepromotion = entity.getBrailepromotion();
        this.guidesystem = entity.getGuidesystem();
        this.blindhandicapetc = entity.getBlindhandicapetc();
        this.signguide = entity.getSignguide();
        this.videoguide = entity.getVideoguide();
        this.hearingroom = entity.getHearingroom();
        this.hearinghandicapetc = entity.getHearinghandicapetc();
        this.stroller = entity.getStroller();
        this.lactationroom = entity.getLactationroom();
        this.babysparechair = entity.getBabysparechair();
        this.infantsfamilyetc = entity.getInfantsfamilyetc();
    }
}
