package com.cwm.develop.openApi.detailIntro.dto;

import com.cwm.develop.openApi.detailIntro.entity.DetailIntro12;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DetailIntro12ResponseDto {

    private Long detailIntroId;

    //contentid
    private String contentId;

    //contenttypeid
    private String contenttypeid;

    //heritage1
    private String heritage1;

    //heritage2
    private String heritage2;

    //heritage3
    private String heritage3;

    //infocenter
    private String infocenter;

    //opendate
    private String opendate;

    //restdate
    private String restdate;

    //expguide
    private String expguide;

    //expagerange
    private String expagerange;

    //accomcount
    private String accomcount;

    //useseason
    private String useseason;

    //usetime
    private String usetime;

    //parking
    private String parking;

    //chkbabycarriage
    private String chkbabycarriage;

    //chkpet
    private String chkpet;

    //chkcreditcard
    private String chkcreditcard;

    public DetailIntro12ResponseDto(DetailIntro12 entity) {
        this.detailIntroId = entity.getDetailIntroId();
        this.contentId = entity.getContentId();
        this.contenttypeid = entity.getContenttypeid();
        this.heritage1 = entity.getHeritage1();
        this.heritage2 = entity.getHeritage2();
        this.heritage3 = entity.getHeritage3();
        this.infocenter = entity.getInfocenter();
        this.opendate = entity.getOpendate();
        this.restdate = entity.getRestdate();
        this.expguide = entity.getExpguide();
        this.expagerange = entity.getExpagerange();
        this.accomcount = entity.getAccomcount();
        this.useseason = entity.getUseseason();
        this.usetime = entity.getUsetime();
        this.parking = entity.getParking();
        this.chkbabycarriage = entity.getChkbabycarriage();
        this.chkpet = entity.getChkpet();
        this.chkcreditcard = entity.getChkcreditcard();
    }
}
