package com.cwm.develop.openApi.detailIntro.entity;

import com.cwm.develop.openApi.detailIntro.dto.DetailIntro39Dto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "DETAILINTRO39")
@SuppressWarnings("unused")
public class DetailIntro39 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detailIntroId")
    private Long detailIntroId;

    //contentid
    private String contentId;

    //contenttypeid
    private String contenttypeid;

    @Column(columnDefinition = "LONGTEXT")
    private String seat;

    @Column(columnDefinition = "LONGTEXT")
    private String kidsfacility;

    @Column(columnDefinition = "LONGTEXT")
    private String firstmenu;

    @Column(columnDefinition = "LONGTEXT")
    private String treatmenu;

    @Column(columnDefinition = "LONGTEXT")
    private String smoking;

    @Column(columnDefinition = "LONGTEXT")
    private String packing;

    @Column(columnDefinition = "LONGTEXT")
    private String infocenterfood;

    @Column(columnDefinition = "LONGTEXT")
    private String scalefood;

    @Column(columnDefinition = "LONGTEXT")
    private String parkingfood;

    @Column(columnDefinition = "LONGTEXT")
    private String opendatefood;

    @Column(columnDefinition = "LONGTEXT")
    private String opentimefood;

    @Column(columnDefinition = "LONGTEXT")
    private String restdatefood;

    @Column(columnDefinition = "LONGTEXT")
    private String discountinfofood;

    @Column(columnDefinition = "LONGTEXT")
    private String chkcreditcardfood;

    @Column(columnDefinition = "LONGTEXT")
    private String reservationfood;

    @Column(columnDefinition = "LONGTEXT")
    private String lcnsno;

    public DetailIntro39(Long detailIntroId, String contentId, String contenttypeid, String seat, String kidsfacility, String firstmenu, String treatmenu, String smoking, String packing, String infocenterfood, String scalefood, String parkingfood, String opendatefood, String opentimefood, String restdatefood, String discountinfofood, String chkcreditcardfood, String reservationfood, String lcnsno) {
        this.detailIntroId = detailIntroId;
        this.contentId = contentId;
        this.contenttypeid = contenttypeid;
        this.seat = seat;
        this.kidsfacility = kidsfacility;
        this.firstmenu = firstmenu;
        this.treatmenu = treatmenu;
        this.smoking = smoking;
        this.packing = packing;
        this.infocenterfood = infocenterfood;
        this.scalefood = scalefood;
        this.parkingfood = parkingfood;
        this.opendatefood = opendatefood;
        this.opentimefood = opentimefood;
        this.restdatefood = restdatefood;
        this.discountinfofood = discountinfofood;
        this.chkcreditcardfood = chkcreditcardfood;
        this.reservationfood = reservationfood;
        this.lcnsno = lcnsno;
    }

    public DetailIntro39(DetailIntro39Dto requestDto) {
        this.contentId = requestDto.getContentId();
        this.contenttypeid = requestDto.getContenttypeid();
        this.seat = requestDto.getSeat();
        this.kidsfacility = requestDto.getKidsfacility();
        this.firstmenu = requestDto.getFirstmenu();
        this.treatmenu = requestDto.getTreatmenu();
        this.smoking = requestDto.getSmoking();
        this.packing = requestDto.getPacking();
        this.infocenterfood = requestDto.getInfocenterfood();
        this.scalefood = requestDto.getScalefood();
        this.parkingfood = requestDto.getParkingfood();
        this.opendatefood = requestDto.getOpendatefood();
        this.opentimefood = requestDto.getOpentimefood();
        this.restdatefood = requestDto.getRestdatefood();
        this.discountinfofood = requestDto.getDiscountinfofood();
        this.chkcreditcardfood = requestDto.getChkcreditcardfood();
        this.reservationfood = requestDto.getReservationfood();
        this.lcnsno = requestDto.getLcnsno();
    }
}
