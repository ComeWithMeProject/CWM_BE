package com.cwm.develop.openApi.detailIntro.entity;

import com.cwm.develop.openApi.detailIntro.dto.DetailIntro28Dto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "DETAILINTRO28")
@SuppressWarnings("unused")
public class DetailIntro28 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detailIntroId")
    private Long detailIntroId;

    //contentid
    private String contentId;

    //contenttypeid
    private String contenttypeid;

    @Column(columnDefinition = "LONGTEXT")
    private String openperiod;

    @Column(columnDefinition = "LONGTEXT")
    private String reservation;

    @Column(columnDefinition = "LONGTEXT")
    private String infocenterleports;

    @Column(columnDefinition = "LONGTEXT")
    private String scaleleports;

    @Column(columnDefinition = "LONGTEXT")
    private String accomcountleports;

    @Column(columnDefinition = "LONGTEXT")
    private String restdateleports;

    @Column(columnDefinition = "LONGTEXT")
    private String usetimeleports;

    @Column(columnDefinition = "LONGTEXT")
    private String usefeeleports;

    @Column(columnDefinition = "LONGTEXT")
    private String expagerangeleports;

    @Column(columnDefinition = "LONGTEXT")
    private String parkingleports;

    @Column(columnDefinition = "LONGTEXT")
    private String parkingfeeleports;

    @Column(columnDefinition = "LONGTEXT")
    private String chkbabycarriageleports;

    @Column(columnDefinition = "LONGTEXT")
    private String chkpetleports;

    @Column(columnDefinition = "LONGTEXT")
    private String chkcreditcardleports;


    public DetailIntro28(Long detailIntroId, String contentId, String contenttypeid, String openperiod, String reservation, String infocenterleports, String scaleleports, String accomcountleports, String restdateleports, String usetimeleports, String usefeeleports, String expagerangeleports, String parkingleports, String parkingfeeleports, String chkbabycarriageleports, String chkpetleports, String chkcreditcardleports) {
        this.detailIntroId = detailIntroId;
        this.contentId = contentId;
        this.contenttypeid = contenttypeid;
        this.openperiod = openperiod;
        this.reservation = reservation;
        this.infocenterleports = infocenterleports;
        this.scaleleports = scaleleports;
        this.accomcountleports = accomcountleports;
        this.restdateleports = restdateleports;
        this.usetimeleports = usetimeleports;
        this.usefeeleports = usefeeleports;
        this.expagerangeleports = expagerangeleports;
        this.parkingleports = parkingleports;
        this.parkingfeeleports = parkingfeeleports;
        this.chkbabycarriageleports = chkbabycarriageleports;
        this.chkpetleports = chkpetleports;
        this.chkcreditcardleports = chkcreditcardleports;
    }

    public DetailIntro28(DetailIntro28Dto requestDto) {
        this.contentId = requestDto.getContentId();
        this.contenttypeid = requestDto.getContenttypeid();
        this.openperiod = requestDto.getOpenperiod();
        this.reservation = requestDto.getReservation();
        this.infocenterleports = requestDto.getInfocenterleports();
        this.scaleleports = requestDto.getScaleleports();
        this.accomcountleports = requestDto.getAccomcountleports();
        this.restdateleports = requestDto.getRestdateleports();
        this.usetimeleports = requestDto.getUsetimeleports();
        this.usefeeleports = requestDto.getUsefeeleports();
        this.expagerangeleports = requestDto.getExpagerangeleports();
        this.parkingleports = requestDto.getParkingleports();
        this.parkingfeeleports = requestDto.getParkingfeeleports();
        this.chkbabycarriageleports = requestDto.getChkbabycarriageleports();
        this.chkpetleports = requestDto.getChkpetleports();
        this.chkcreditcardleports = requestDto.getChkcreditcardleports();

    }
}
