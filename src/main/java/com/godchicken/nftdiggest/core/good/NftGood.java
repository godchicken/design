package com.godchicken.nftdiggest.core.good;


import lombok.Data;

import java.util.Date;

@Data
public class NftGood {

    //所属的平台
    protected String platform;

    //产品编号
    protected String productCode;

    //nft主题
    protected String theme;

    //nft名字
    protected String name;

    //作者
    protected String author;

    //发行方
    protected String publisher;

    //发行日期
    protected Date publishTime;

    //状态
    protected Integer GoodStatus;

    //报价
    protected Long price;

    //上次成交价格
    protected Long lastDealPrice;

    //交易次数
    protected Integer dealTime;

    //商品URl
    protected String goodUrl;

    //商品图片
    protected String imgUrl;


}
