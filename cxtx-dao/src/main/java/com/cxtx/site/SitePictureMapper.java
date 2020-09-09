package com.cxtx.site;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SitePictureMapper {

    /**
     * 插入新的景区图片
     * @param sitePicture
     * @return
     */
    public int insertSitePictures(List<SitePicture> sitePicture);



}
