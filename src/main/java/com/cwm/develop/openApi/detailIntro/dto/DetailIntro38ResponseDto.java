package com.cwm.develop.openApi.detailIntro.dto;

import com.cwm.develop.openApi.detailIntro.entity.DetailIntro38;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DetailIntro38ResponseDto {

    private Long detailIntroId;

    //contentid
    private String contentId;

    //contenttypeid
    private String contenttypeid;

    private String saleitem;

    private String saleitemcost;

    private String fairday;

    private String opendateshopping;

    private String shopguide;

    private String culturecenter;

    private String restroom;

    private String infocentershopping;

    private String scaleshopping;

    private String restdateshopping;

    private String parkingshopping;

    private String chkbabycarriageshopping;

    private String chkpetshopping;

    private String chkcreditcardshopping;

    private String opentime;

    public DetailIntro38ResponseDto(DetailIntro38 entity) {
        this.detailIntroId = entity.getDetailIntroId();
        this.contentId = entity.getContentId();
        this.contenttypeid = entity.getContenttypeid();
        this.saleitem = entity.getSaleitem();
        this.saleitemcost = entity.getSaleitemcost();
        this.fairday = entity.getFairday();
        this.opendateshopping = entity.getOpendateshopping();
        this.shopguide = entity.getShopguide();
        this.culturecenter = entity.getCulturecenter();
        this.restroom = entity.getRestroom();
        this.infocentershopping = entity.getInfocentershopping();
        this.scaleshopping = entity.getScaleshopping();
        this.restdateshopping = entity.getRestdateshopping();
        this.parkingshopping = entity.getParkingshopping();
        this.chkbabycarriageshopping = entity.getChkbabycarriageshopping();
        this.chkpetshopping = entity.getChkpetshopping();
        this.chkcreditcardshopping = entity.getChkcreditcardshopping();
        this.opentime = entity.getOpentime();
    }

}
