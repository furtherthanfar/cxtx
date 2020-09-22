package com.cxtx.site;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SiteMapper {

    /**
     * 查找所有的景点信息
     * @return
     */
    public List<Site> selectAllSites();

    /**
     * 根据景区ID查找景区
     * @param site_id
     * @return
     */
    public Site selectSiteById(int site_id);

    /**
     * 根据景区ID查找景区的某些图片
     * @param site_id
     * @param rowBounds
     * @return
     */
    public List<SitePicture> selectPicturesBySiteId(int site_id, RowBounds rowBounds);

    /**
     * 插入一个新的Site
     * @param site
     * @return
     */
    public int insertSite(Site site);

    /**
     * 删除一个Site
     * @param site_id
     */
    public void deleteSiteById(int site_id);
}
