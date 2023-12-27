package com.cwm.develop.openApi.detailIntro.entity;

import com.cwm.develop.openApi.detailIntro.dto.DetailIntro32Dto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "DETAILINTRO32")
@SuppressWarnings("unused")
public class DetailIntro32 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detailIntroId")
    private Long detailIntroId;

    //contentid
    private String contentId;

    //contenttypeid
    private String contenttypeid;

    @Column(columnDefinition = "LONGTEXT")
    private String goodstay;

    @Column(columnDefinition = "LONGTEXT")
    private String benikia;

    @Column(columnDefinition = "LONGTEXT")
    private String hanok;

    @Column(columnDefinition = "LONGTEXT")
    private String roomcount;

    @Column(columnDefinition = "LONGTEXT")
    private String roomtype;

    @Column(columnDefinition = "LONGTEXT")
    private String refundregulation;

    @Column(columnDefinition = "LONGTEXT")
    private String checkintime;

    @Column(columnDefinition = "LONGTEXT")
    private String checkouttime;

    @Column(columnDefinition = "LONGTEXT")
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

    @Column(columnDefinition = "LONGTEXT")
    private String pickup;

    private String infocenterlodging;

    @Column(columnDefinition = "LONGTEXT")
    private String parkinglodging;

    @Column(columnDefinition = "LONGTEXT")
    private String reservationlodging;

    @Column(columnDefinition = "LONGTEXT")
    private String scalelodging;

    @Column(columnDefinition = "LONGTEXT")
    private String accomcountlodging;

    public DetailIntro32(Long detailIntroId, String contentId, String contenttypeid, String goodstay, String benikia, String hanok, String roomcount, String roomtype, String refundregulation, String checkintime, String checkouttime, String chkcooking, String seminar, String sports, String sauna, String beauty, String beverage, String karaoke, String barbecue, String campfire, String bicycle, String fitness, String publicpc, String publicbath, String subfacility, String foodplace, String reservationurl, String pickup, String infocenterlodging, String parkinglodging, String reservationlodging, String scalelodging, String accomcountlodging) {
        this.detailIntroId = detailIntroId;
        this.contentId = contentId;
        this.contenttypeid = contenttypeid;
        this.goodstay = goodstay;
        this.benikia = benikia;
        this.hanok = hanok;
        this.roomcount = roomcount;
        this.roomtype = roomtype;
        this.refundregulation = refundregulation;
        this.checkintime = checkintime;
        this.checkouttime = checkouttime;
        this.chkcooking = chkcooking;
        this.seminar = seminar;
        this.sports = sports;
        this.sauna = sauna;
        this.beauty = beauty;
        this.beverage = beverage;
        this.karaoke = karaoke;
        this.barbecue = barbecue;
        this.campfire = campfire;
        this.bicycle = bicycle;
        this.fitness = fitness;
        this.publicpc = publicpc;
        this.publicbath = publicbath;
        this.subfacility = subfacility;
        this.foodplace = foodplace;
        this.reservationurl = reservationurl;
        this.pickup = pickup;
        this.infocenterlodging = infocenterlodging;
        this.parkinglodging = parkinglodging;
        this.reservationlodging = reservationlodging;
        this.scalelodging = scalelodging;
        this.accomcountlodging = accomcountlodging;
    }

    public DetailIntro32(DetailIntro32Dto requestDto) {
        this.contentId = requestDto.getContentId();
        this.contenttypeid = requestDto.getContenttypeid();
        this.goodstay = requestDto.getGoodstay();
        this.benikia = requestDto.getBenikia();
        this.hanok = requestDto.getHanok();
        this.roomcount = requestDto.getRoomcount();
        this.roomtype = requestDto.getRoomtype();
        this.refundregulation = requestDto.getRefundregulation();
        this.checkintime = requestDto.getCheckintime();
        this.checkouttime = requestDto.getCheckouttime();
        this.chkcooking = requestDto.getChkcooking();
        this.seminar = requestDto.getSeminar();
        this.sports = requestDto.getSports();
        this.sauna = requestDto.getSauna();
        this.beauty = requestDto.getBeauty();
        this.beverage = requestDto.getBeverage();
        this.karaoke = requestDto.getKaraoke();
        this.barbecue = requestDto.getBarbecue();
        this.campfire = requestDto.getCampfire();
        this.bicycle = requestDto.getBicycle();
        this.fitness = requestDto.getFitness();
        this.publicpc = requestDto.getPublicpc();
        this.publicbath = requestDto.getPublicbath();
        this.subfacility = requestDto.getSubfacility();
        this.foodplace = requestDto.getFoodplace();
        this.reservationurl = requestDto.getReservationurl();
        this.pickup = requestDto.getPickup();
        this.infocenterlodging = requestDto.getInfocenterlodging();
        this.parkinglodging = requestDto.getParkinglodging();
        this.reservationlodging = requestDto.getReservationlodging();
        this.scalelodging = requestDto.getScalelodging();
        this.accomcountlodging = requestDto.getAccomcountlodging();
    }
}
