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

}
