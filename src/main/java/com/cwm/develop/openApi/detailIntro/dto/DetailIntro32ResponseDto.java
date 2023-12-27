package com.cwm.develop.openApi.detailIntro.dto;

import com.cwm.develop.openApi.detailIntro.entity.DetailIntro32;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DetailIntro32ResponseDto {

    private Long detailIntroId;

    //contentid
    private String contentId;

    //contenttypeid
    private String contenttypeid;

    private String goodstay;

    private String benikia;

    private String hanok;

    private String roomcount;

    private String roomtype;

    private String refundregulation;

    private String checkintime;

    private String checkouttime;

    private String chkcooking;

    private String seminar;

    private String sports;

    private String sauna;

    private String beauty;

    private String beverage;

    private String karaoke;

    private String barbecue;

    private String campfire;

    private String bicycle;

    private String fitness;

    private String publicpc;

    private String publicbath;

    private String subfacility;

    private String foodplace;

    private String reservationurl;

    private String pickup;

    private String infocenterlodging;

    private String parkinglodging;

    private String reservationlodging;

    private String scalelodging;

    private String accomcountlodging;

    public DetailIntro32ResponseDto(DetailIntro32 entity) {
        this.detailIntroId = entity.getDetailIntroId();
        this.contentId = entity.getContentId();
        this.contenttypeid = entity.getContenttypeid();
        this.goodstay = entity.getGoodstay();
        this.benikia = entity.getBenikia();
        this.hanok = entity.getHanok();
        this.roomcount = entity.getRoomcount();
        this.roomtype = entity.getRoomtype();
        this.refundregulation = entity.getRefundregulation();
        this.checkintime = entity.getCheckintime();
        this.checkouttime = entity.getCheckouttime();
        this.chkcooking = entity.getChkcooking();
        this.seminar = entity.getSeminar();
        this.sports = entity.getSports();
        this.sauna = entity.getSauna();
        this.beauty = entity.getBeauty();
        this.beverage = entity.getBeverage();
        this.karaoke = entity.getKaraoke();
        this.barbecue = entity.getBarbecue();
        this.campfire = entity.getCampfire();
        this.bicycle = entity.getBicycle();
        this.fitness = entity.getFitness();
        this.publicpc = entity.getPublicpc();
        this.publicbath = entity.getPublicbath();
        this.subfacility = entity.getSubfacility();
        this.foodplace = entity.getFoodplace();
        this.reservationurl = entity.getReservationurl();
        this.pickup = entity.getPickup();
        this.infocenterlodging = entity.getInfocenterlodging();
        this.parkinglodging = entity.getParkinglodging();
        this.reservationlodging = entity.getReservationlodging();
        this.scalelodging = entity.getScalelodging();
        this.accomcountlodging = entity.getAccomcountlodging();
    }
}
