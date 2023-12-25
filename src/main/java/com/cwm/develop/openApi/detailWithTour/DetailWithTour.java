package com.cwm.develop.openApi.detailWithTour;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "DETAILWITHTOUR")
public class DetailWithTour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detailWithTourId")
    private Long detailWithTourId;

    //contentid
    private String contentId;

    //parking
    private String parking;

    //route
    private String route;

    //publictransport
    private String publictransport;

    //ticketoffice
    private String ticketoffice;

    //promotion
    private String promotion;

    //wheelchair
    private String wheelchair;

    // exit
    @Column(name = "\"exit\"")
    private String exit;

    //elevator
    private String elevator;

    //restroom
    private String restroom;

    //auditorium
    private String auditorium;

    //room
    private String room;

    //handicapetc
    private String handicapetc;

    //braileblock
    private String braileblock;

    //helpdog
    private String helpdog;

    //guidehuman
    private String guidehuman;

    //audioguide
    private String audioguide;

    //bigprint
    private String bigprint;

    //brailepromotion
    private String brailepromotion;

    //guidesystem
    private String guidesystem;

    //blindhandicapetc
    private String blindhandicapetc;

    //signguide
    private String signguide;

    //videoguide
    private String videoguide;

    //hearingroom
    private String hearingroom;

    //hearinghandicapetc
    private String hearinghandicapetc;

    //stroller
    private String stroller;

    //lactationroom
    private String lactationroom;

    //babysparechair
    private String babysparechair;

    //infantsfamilyetc
    private String infantsfamilyetc;

    public DetailWithTour(Long detailWithTourId, String contentId, String parking, String route, String publictransport, String ticketoffice, String promotion, String wheelchair, String exit, String elevator, String restroom, String auditorium, String room, String handicapetc, String braileblock, String helpdog, String guidehuman, String audioguide, String bigprint, String brailepromotion, String guidesystem, String blindhandicapetc, String signguide, String videoguide, String hearingroom, String hearinghandicapetc, String stroller, String lactationroom, String babysparechair, String infantsfamilyetc) {
        this.detailWithTourId = detailWithTourId;
        this.contentId = contentId;
        this.parking = parking;
        this.route = route;
        this.publictransport = publictransport;
        this.ticketoffice = ticketoffice;
        this.promotion = promotion;
        this.wheelchair = wheelchair;
        this.exit = exit;
        this.elevator = elevator;
        this.restroom = restroom;
        this.auditorium = auditorium;
        this.room = room;
        this.handicapetc = handicapetc;
        this.braileblock = braileblock;
        this.helpdog = helpdog;
        this.guidehuman = guidehuman;
        this.audioguide = audioguide;
        this.bigprint = bigprint;
        this.brailepromotion = brailepromotion;
        this.guidesystem = guidesystem;
        this.blindhandicapetc = blindhandicapetc;
        this.signguide = signguide;
        this.videoguide = videoguide;
        this.hearingroom = hearingroom;
        this.hearinghandicapetc = hearinghandicapetc;
        this.stroller = stroller;
        this.lactationroom = lactationroom;
        this.babysparechair = babysparechair;
        this.infantsfamilyetc = infantsfamilyetc;
    }
}
