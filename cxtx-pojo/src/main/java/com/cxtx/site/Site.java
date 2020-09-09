package com.cxtx.site;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(scopeName = "prototype")
public class Site {

    // 景点ID
    private int id;
    // 景点名称
    private String name;
    // 景点描述
    private String description;
    // 城市名称
    private String cityName;
    // 价钱
    private float price;
    // 折扣
    private float discount;
    // 打折原因
    private String dcReason;
    // 图片路径
    private List<SitePicture> pictures;

    public Site() {
    }

    public void build(int id, String name, String description, String cityName, float price, float discount, String dcReason, List<SitePicture> pictures) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cityName = cityName;
        this.price = price;
        this.discount = discount;
        this.dcReason = dcReason;
        this.pictures = pictures;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getDcReason() {
        return dcReason;
    }

    public void setDcReason(String dcReason) {
        this.dcReason = dcReason;
    }

    public List<SitePicture> getPictures() {
        return pictures;
    }

    public void setPictures(List<SitePicture> pictures) {
        this.pictures = pictures;
    }
}
