package com.cwm.develop.openApi.detailIntro.dto;

import com.cwm.develop.openApi.detailIntro.entity.DetailIntro39;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DetailIntro39ResponseDto {

    private Long detailIntroId;

    //contentid
    private String contentId;

    //contenttypeid
    private String contenttypeid;

    private String seat;

    private String kidsfacility;

    private String firstmenu;

    private String treatmenu;

    private String smoking;

    private String packing;

    private String infocenterfood;

    private String scalefood;

    private String parkingfood;

    private String opendatefood;

    private String opentimefood;

    private String restdatefood;

    private String discountinfofood;

    private String chkcreditcardfood;

    private String reservationfood;

    private String lcnsno;

    public DetailIntro39ResponseDto(DetailIntro39 entity) {
        this.detailIntroId = entity.getDetailIntroId();
        this.contentId = entity.getContentId();
        this.contenttypeid = entity.getContenttypeid();
        this.seat = entity.getSeat();
        this.kidsfacility = entity.getKidsfacility();
        this.firstmenu = entity.getFirstmenu();
        this.treatmenu = entity.getTreatmenu();
        this.smoking = entity.getSmoking();
        this.packing = entity.getPacking();
        this.infocenterfood = entity.getInfocenterfood();
        this.scalefood = entity.getScalefood();
        this.parkingfood = entity.getParkingfood();
        this.opendatefood = entity.getOpendatefood();
        this.opentimefood = entity.getOpentimefood();
        this.restdatefood = entity.getRestdatefood();
        this.discountinfofood = entity.getDiscountinfofood();
        this.chkcreditcardfood = entity.getChkcreditcardfood();
        this.reservationfood = entity.getReservationfood();
        this.lcnsno = entity.getLcnsno();
    }
}
