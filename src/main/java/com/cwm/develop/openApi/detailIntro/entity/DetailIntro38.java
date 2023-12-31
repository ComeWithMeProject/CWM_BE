package com.cwm.develop.openApi.detailIntro.entity;

import com.cwm.develop.openApi.detailIntro.dto.DetailIntro38Dto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "DETAILINTRO38")
@SuppressWarnings("unused")
public class DetailIntro38 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detailIntroId")
    private Long detailIntroId;

    //contentid
    private String contentId;

    //contenttypeid
    private String contenttypeid;

    @Column(columnDefinition = "LONGTEXT")
    private String saleitem;

    @Column(columnDefinition = "LONGTEXT")
    private String saleitemcost;

    @Column(columnDefinition = "LONGTEXT")
    private String fairday;

    @Column(columnDefinition = "LONGTEXT")
    private String opendateshopping;

    @Column(columnDefinition = "LONGTEXT")
    private String shopguide;

    @Column(columnDefinition = "LONGTEXT")
    private String culturecenter;

    @Column(columnDefinition = "LONGTEXT")
    private String restroom;

    @Column(columnDefinition = "LONGTEXT")
    private String infocentershopping;

    @Column(columnDefinition = "LONGTEXT")
    private String scaleshopping;

    @Column(columnDefinition = "LONGTEXT")
    private String restdateshopping;

    @Column(columnDefinition = "LONGTEXT")
    private String parkingshopping;

    @Column(columnDefinition = "LONGTEXT")
    private String chkbabycarriageshopping;

    @Column(columnDefinition = "LONGTEXT")
    private String chkpetshopping;

    @Column(columnDefinition = "LONGTEXT")
    private String chkcreditcardshopping;

    @Column(columnDefinition = "LONGTEXT")
    private String opentime;

    public DetailIntro38(Long detailIntroId, String contentId, String contenttypeid, String saleitem, String saleitemcost, String fairday, String opendateshopping, String shopguide, String culturecenter, String restroom, String infocentershopping, String scaleshopping, String restdateshopping, String parkingshopping, String chkbabycarriageshopping, String chkpetshopping, String chkcreditcardshopping, String opentime) {
        this.detailIntroId = detailIntroId;
        this.contentId = contentId;
        this.contenttypeid = contenttypeid;
        this.saleitem = saleitem;
        this.saleitemcost = saleitemcost;
        this.fairday = fairday;
        this.opendateshopping = opendateshopping;
        this.shopguide = shopguide;
        this.culturecenter = culturecenter;
        this.restroom = restroom;
        this.infocentershopping = infocentershopping;
        this.scaleshopping = scaleshopping;
        this.restdateshopping = restdateshopping;
        this.parkingshopping = parkingshopping;
        this.chkbabycarriageshopping = chkbabycarriageshopping;
        this.chkpetshopping = chkpetshopping;
        this.chkcreditcardshopping = chkcreditcardshopping;
        this.opentime = opentime;
    }

    public DetailIntro38(DetailIntro38Dto requestDto) {
        this.contentId = requestDto.getContentId();
        this.contenttypeid = requestDto.getContenttypeid();
        this.saleitem = requestDto.getSaleitem();
        this.saleitemcost = requestDto.getSaleitemcost();
        this.fairday = requestDto.getFairday();
        this.opendateshopping = requestDto.getOpendateshopping();
        this.shopguide = requestDto.getShopguide();
        this.culturecenter = requestDto.getCulturecenter();
        this.restroom = requestDto.getRestroom();
        this.infocentershopping = requestDto.getInfocentershopping();
        this.scaleshopping = requestDto.getScaleshopping();
        this.restdateshopping = requestDto.getRestdateshopping();
        this.parkingshopping = requestDto.getParkingshopping();
        this.chkbabycarriageshopping = requestDto.getChkbabycarriageshopping();
        this.chkpetshopping = requestDto.getChkpetshopping();
        this.chkcreditcardshopping = requestDto.getChkcreditcardshopping();
        this.opentime = requestDto.getOpentime();
    }
}
