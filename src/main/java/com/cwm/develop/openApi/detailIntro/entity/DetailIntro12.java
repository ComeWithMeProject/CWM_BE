package com.cwm.develop.openApi.detailIntro.entity;

import com.cwm.develop.openApi.detailIntro.dto.DetailIntro12Dto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "DETAILINTRO12")
@SuppressWarnings("unused")
public class DetailIntro12 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detailIntroId")
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
    @Column(columnDefinition = "LONGTEXT")
    private String expguide;

    //expagerange
    private String expagerange;

    //accomcount
    private String accomcount;

    //useseason
    private String useseason;

    //usetime
    @Column(columnDefinition = "LONGTEXT")
    private String usetime;

    //parking
    private String parking;

    //chkbabycarriage
    private String chkbabycarriage;

    //chkpet
    private String chkpet;

    //chkcreditcard
    private String chkcreditcard;

    public DetailIntro12(Long detailIntroId, String contentId, String contenttypeid, String heritage1, String heritage2, String heritage3, String infocenter, String opendate, String restdate, String expguide, String expagerange, String accomcount, String useseason, String usetime, String parking, String chkbabycarriage, String chkpet, String chkcreditcard) {
        this.detailIntroId = detailIntroId;
        this.contentId = contentId;
        this.contenttypeid = contenttypeid;
        this.heritage1 = heritage1;
        this.heritage2 = heritage2;
        this.heritage3 = heritage3;
        this.infocenter = infocenter;
        this.opendate = opendate;
        this.restdate = restdate;
        this.expguide = expguide;
        this.expagerange = expagerange;
        this.accomcount = accomcount;
        this.useseason = useseason;
        this.usetime = usetime;
        this.parking = parking;
        this.chkbabycarriage = chkbabycarriage;
        this.chkpet = chkpet;
        this.chkcreditcard = chkcreditcard;
    }

    //@SuppressWarnings("unused") - 해당 어노테이션으로 아래 생성자 생성 가능해짐
    public DetailIntro12(DetailIntro12Dto detailIntro12Dto) {
        this.contentId = detailIntro12Dto.getContentId();
        this.contenttypeid = detailIntro12Dto.getContenttypeid();
        this.heritage1 = detailIntro12Dto.getHeritage1();
        this.heritage2 = detailIntro12Dto.getHeritage2();
        this.heritage3 = detailIntro12Dto.getHeritage3();
        this.infocenter = detailIntro12Dto.getInfocenter();
        this.opendate = detailIntro12Dto.getOpendate();
        this.restdate = detailIntro12Dto.getRestdate();
        this.expguide = detailIntro12Dto.getExpguide();
        this.expagerange = detailIntro12Dto.getExpagerange();
        this.accomcount = detailIntro12Dto.getAccomcount();
        this.useseason = detailIntro12Dto.getUseseason();
        this.usetime = detailIntro12Dto.getUsetime();
        this.parking = detailIntro12Dto.getParking();
        this.chkbabycarriage = detailIntro12Dto.getChkbabycarriage();
        this.chkpet = detailIntro12Dto.getChkpet();
        this.chkcreditcard = detailIntro12Dto.getChkcreditcard();
    }
}
