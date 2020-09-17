package com.cxtx.site;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteService {

    @Autowired
    private SiteMapper siteMapper;


    public List<Site> selectAllSites(){
        return siteMapper.selectAllSites();
    }
    /**
     * 根据景区ID查找景区
     * @param site_id
     * @return
     */
    public Site selectSiteById(int site_id){
        return siteMapper.selectSiteById(site_id);
    }

    /**
     * 根据景区ID查找景区的全部图片
     * @param site_id
     * @param rowBounds
     * @return
     */
    public List<SitePicture> selectPicturesBySiteId(@Param("site_id") int site_id, RowBounds rowBounds){
        return siteMapper.selectPicturesBySiteId(site_id, new RowBounds(0, 10000));
    }


    /**
     * 根据景区ID查找景区的一个图片
     * @param site_id
     * @param rowBounds
     * @return
     */
    public List<SitePicture> select1PicturesBySiteId(int site_id, RowBounds rowBounds){
        return siteMapper.selectPicturesBySiteId(site_id, new RowBounds(0, 1));
    }


    /**
     * 插入一个新的Site
     * @param site
     * @return
     */
    public int insertSite(Site site){
        return siteMapper.insertSite(site);
    }
}
