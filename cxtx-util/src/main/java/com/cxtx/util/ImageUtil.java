package com.cxtx.util;

import org.springframework.stereotype.Component;

/**
 * 图像工具类
 */
@Component
public class ImageUtil {

    private static final String[] LIMIT = {".jpg",".png",".jpeg",".bmp"};
    public static final String PATH = "cxtx-web\\src\\main\\resources\\static\\upload\\imgs";
    /**
     * 审查图片格式是否合格
     * @param originalName
     * @return
     */
    public boolean isImageLegal(String originalName){
        String original = originalName.toLowerCase();
        for(String string : LIMIT){
            if(original.endsWith(string)){
                return true;
            }
        }
        return false;
    }

}
