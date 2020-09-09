package com.cxtx.site;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SitePictureService {

    @Autowired
    private SitePictureMapper sitePictureMapper;

    /**
     * 插入新的景区图片
     * @param sitePicture
     * @return
     */
    public int insertSitePictures(List<SitePicture> sitePicture){
        return sitePictureMapper.insertSitePictures(sitePicture);
    }


}
