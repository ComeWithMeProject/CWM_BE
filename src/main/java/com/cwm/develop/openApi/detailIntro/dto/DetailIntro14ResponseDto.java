package com.cwm.develop.openApi.detailIntro.dto;

import com.cwm.develop.openApi.detailIntro.entity.DetailIntro14;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DetailIntro14ResponseDto {

    private Long detailIntroId;

    //contentid
    private String contentId;

    //contenttypeid
    private String contenttypeid;

    private String scale;

    private String usefee;

    private String discountinfo;

    private String spendtime;

    private String parkingfee;

    private String infocenterculture;

    private String accomcountculture;

    private String usetimeculture;

    private String restdateculture;

    private String parkingculture;

    private String chkbabycarriageculture;

    private String chkpetculture;

    private String chkcreditcardculture;

    public DetailIntro14ResponseDto(DetailIntro14 entity) {
        this.contentId = entity.getContentId();
        this.contenttypeid = entity.getContenttypeid();
        this.scale = entity.getScale();
        this.usefee = entity.getUsefee();
        this.discountinfo = entity.getDiscountinfo();
        this.spendtime = entity.getSpendtime();
        this.parkingfee = entity.getParkingfee();
        this.infocenterculture = entity.getInfocenterculture();
        this.accomcountculture = entity.getAccomcountculture();
        this.usetimeculture = entity.getUsetimeculture();
        this.restdateculture = entity.getRestdateculture();
        this.parkingculture = entity.getParkingculture();
        this.chkbabycarriageculture = entity.getChkbabycarriageculture();
        this.chkpetculture = entity.getChkpetculture();
        this.chkcreditcardculture = entity.getChkcreditcardculture();
    }
}
