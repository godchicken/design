package com.godchicken.nftdiggest.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (NftGoods)实体类
 *
 * @author makejava
 * @since 2022-04-17 21:45:53
 */
public class NftGoods implements Serializable {
    private static final long serialVersionUID = -56287639844783833L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 平台
    */
    private String platform;
    
    private String productCode;
    
    private String theme;
    
    private String name;
    
    private String author;
    
    private String publisher;
    
    private Integer goodStatus;
    
    private Integer price;
    
    private Integer lastDealPrice;
    
    private Integer dealTime;
    
    private String goodUrl;
    
    private String imgUrl;
    
    private Date publishTime;
    
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getGoodStatus() {
        return goodStatus;
    }

    public void setGoodStatus(Integer goodStatus) {
        this.goodStatus = goodStatus;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getLastDealPrice() {
        return lastDealPrice;
    }

    public void setLastDealPrice(Integer lastDealPrice) {
        this.lastDealPrice = lastDealPrice;
    }

    public Integer getDealTime() {
        return dealTime;
    }

    public void setDealTime(Integer dealTime) {
        this.dealTime = dealTime;
    }

    public String getGoodUrl() {
        return goodUrl;
    }

    public void setGoodUrl(String goodUrl) {
        this.goodUrl = goodUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}