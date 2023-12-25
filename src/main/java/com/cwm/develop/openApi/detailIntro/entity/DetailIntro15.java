package com.cwm.develop.openApi.detailIntro.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "DETAILINTRO15")
public class DetailIntro15 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detailIntroId")
    private Long detailIntroId;

    //contentid
    private String contentId;

    //contenttypeid
    private String contenttypeid;

    @Column(columnDefinition = "LONGTEXT")
    private String sponsor1;

    @Column(columnDefinition = "LONGTEXT")
    private String sponsor1tel;

    @Column(columnDefinition = "LONGTEXT")
    private String sponsor2;

    @Column(columnDefinition = "LONGTEXT")
    private String sponsor2tel;

    @Column(columnDefinition = "LONGTEXT")
    private String eventenddate;

    @Column(columnDefinition = "LONGTEXT")
    private String playtime;

    @Column(columnDefinition = "LONGTEXT")
    private String eventplace;

    @Column(columnDefinition = "LONGTEXT")
    private String eventhomepage;

    @Column(columnDefinition = "LONGTEXT")
    private String agelimit;

    @Column(columnDefinition = "LONGTEXT")
    private String bookingplace;

    @Column(columnDefinition = "LONGTEXT")
    private String placeinfo;

    @Column(columnDefinition = "LONGTEXT")
    private String subevent;

    @Column(columnDefinition = "LONGTEXT")
    private String program;

    @Column(columnDefinition = "LONGTEXT")
    private String eventstartdate;

    @Column(columnDefinition = "LONGTEXT")
    private String usetimefestival;

    @Column(columnDefinition = "LONGTEXT")
    private String discountinfofestival;

    @Column(columnDefinition = "LONGTEXT")
    private String spendtimefestival;

    @Column(columnDefinition = "LONGTEXT")
    private String festivalgrade;

    public DetailIntro15(Long detailIntroId, String contentId, String contenttypeid, String sponsor1, String sponsor1tel, String sponsor2, String sponsor2tel, String eventenddate, String playtime, String eventplace, String eventhomepage, String agelimit, String bookingplace, String placeinfo, String subevent, String program, String eventstartdate, String usetimefestival, String discountinfofestival, String spendtimefestival, String festivalgrade) {
        this.detailIntroId = detailIntroId;
        this.contentId = contentId;
        this.contenttypeid = contenttypeid;
        this.sponsor1 = sponsor1;
        this.sponsor1tel = sponsor1tel;
        this.sponsor2 = sponsor2;
        this.sponsor2tel = sponsor2tel;
        this.eventenddate = eventenddate;
        this.playtime = playtime;
        this.eventplace = eventplace;
        this.eventhomepage = eventhomepage;
        this.agelimit = agelimit;
        this.bookingplace = bookingplace;
        this.placeinfo = placeinfo;
        this.subevent = subevent;
        this.program = program;
        this.eventstartdate = eventstartdate;
        this.usetimefestival = usetimefestival;
        this.discountinfofestival = discountinfofestival;
        this.spendtimefestival = spendtimefestival;
        this.festivalgrade = festivalgrade;
    }
}
