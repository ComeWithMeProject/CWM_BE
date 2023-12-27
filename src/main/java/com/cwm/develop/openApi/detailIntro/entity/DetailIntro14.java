package com.cwm.develop.openApi.detailIntro.entity;

import com.cwm.develop.openApi.detailIntro.dto.DetailIntro14Dto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "DETAILINTRO14")
@SuppressWarnings("unused")
public class DetailIntro14 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detailIntroId")
    private Long detailIntroId;

    //contentid
    private String contentId;

    //contenttypeid
    private String contenttypeid;

    @Column(columnDefinition = "LONGTEXT")
    private String scale;

    @Column(columnDefinition = "LONGTEXT")
    private String usefee;

    @Column(columnDefinition = "LONGTEXT")
    private String discountinfo;

    @Column(columnDefinition = "LONGTEXT")
    private String spendtime;

    @Column(columnDefinition = "LONGTEXT")
    private String parkingfee;

    @Column(columnDefinition = "LONGTEXT")
    private String infocenterculture;

    @Column(columnDefinition = "LONGTEXT")
    private String accomcountculture;

    @Column(columnDefinition = "LONGTEXT")
    private String usetimeculture;

    @Column(columnDefinition = "LONGTEXT")
    private String restdateculture;

    @Column(columnDefinition = "LONGTEXT")
    private String parkingculture;

    @Column(columnDefinition = "LONGTEXT")
    private String chkbabycarriageculture;

    @Column(columnDefinition = "LONGTEXT")
    private String chkpetculture;

    @Column(columnDefinition = "LONGTEXT")
    private String chkcreditcardculture;

    public DetailIntro14(Long detailIntroId, String contentId, String contenttypeid, String scale, String usefee, String discountinfo, String spendtime, String parkingfee, String infocenterculture, String accomcountculture, String usetimeculture, String restdateculture, String parkingculture, String chkbabycarriageculture, String chkpetculture, String chkcreditcardculture) {
        this.detailIntroId = detailIntroId;
        this.contentId = contentId;
        this.contenttypeid = contenttypeid;
        this.scale = scale;
        this.usefee = usefee;
        this.discountinfo = discountinfo;
        this.spendtime = spendtime;
        this.parkingfee = parkingfee;
        this.infocenterculture = infocenterculture;
        this.accomcountculture = accomcountculture;
        this.usetimeculture = usetimeculture;
        this.restdateculture = restdateculture;
        this.parkingculture = parkingculture;
        this.chkbabycarriageculture = chkbabycarriageculture;
        this.chkpetculture = chkpetculture;
        this.chkcreditcardculture = chkcreditcardculture;
    }

    public DetailIntro14(DetailIntro14Dto requestDto) {
        this.contentId = requestDto.getContentId();
        this.contenttypeid = requestDto.getContenttypeid();
        this.scale = requestDto.getScale();
        this.usefee = requestDto.getUsefee();
        this.discountinfo = requestDto.getDiscountinfo();
        this.spendtime = requestDto.getSpendtime();
        this.parkingfee = requestDto.getParkingfee();
        this.infocenterculture = requestDto.getInfocenterculture();
        this.accomcountculture = requestDto.getAccomcountculture();
        this.usetimeculture = requestDto.getUsetimeculture();
        this.restdateculture = requestDto.getRestdateculture();
        this.parkingculture = requestDto.getParkingculture();
        this.chkbabycarriageculture = requestDto.getChkbabycarriageculture();
        this.chkpetculture = requestDto.getChkpetculture();
        this.chkcreditcardculture = requestDto.getChkcreditcardculture();
    }
}
