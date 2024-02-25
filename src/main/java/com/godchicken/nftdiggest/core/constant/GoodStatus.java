package com.godchicken.nftdiggest.core.constant;

public enum GoodStatus {

    UNPUBLISH("未发布",0),
    ON_SALE("在售",1),
    SALE_OUT("售罄",2),
    OTHER("其他",9)
    ;

    GoodStatus(String name, Integer staus) {
        this.name = name;
        this.staus = staus;
    }

    private String name;

    private Integer staus;
}
