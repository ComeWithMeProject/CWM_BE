package com.cwm.develop.openApi.detailIntro.dto;

import com.cwm.develop.openApi.detailIntro.entity.DetailIntro28;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DetailIntro28ResponseDto {
    private Long detailIntroId;

    //contentid
    private String contentId;

    //contenttypeid
    private String contenttypeid;

    private String openperiod;

    private String reservation;

    private String infocenterleports;

    private String scaleleports;

    private String accomcountleports;

    private String restdateleports;

    private String usetimeleports;

    private String usefeeleports;

    private String expagerangeleports;

    private String parkingleports;

    private String parkingfeeleports;

    private String chkbabycarriageleports;

    private String chkpetleports;

    private String chkcreditcardleports;

    public DetailIntro28ResponseDto(DetailIntro28 entity) {
        this.detailIntroId = entity.getDetailIntroId();
        this.contentId = entity.getContentId();
        this.contenttypeid = entity.getContenttypeid();
        this.openperiod = entity.getOpenperiod();
        this.reservation = entity.getReservation();
        this.infocenterleports = entity.getInfocenterleports();
        this.scaleleports = entity.getScaleleports();
        this.accomcountleports = entity.getAccomcountleports();
        this.restdateleports = entity.getRestdateleports();
        this.usetimeleports = entity.getUsetimeleports();
        this.usefeeleports = entity.getUsefeeleports();
        this.expagerangeleports = entity.getExpagerangeleports();
        this.parkingleports = entity.getParkingleports();
        this.parkingfeeleports = entity.getParkingfeeleports();
        this.chkbabycarriageleports = entity.getChkbabycarriageleports();
        this.chkpetleports = entity.getChkpetleports();
        this.chkcreditcardleports = entity.getChkcreditcardleports();
    }
}
