package com.cxtx.site;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class SitePicture implements Serializable {

    // 图片 ID
    private int id;
    // 路径
    private String path;
    // 景点 ID
    private int site_id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getSite_id() {
        return site_id;
    }

    public void setSite_id(int site_id) {
        this.site_id = site_id;
    }
}
