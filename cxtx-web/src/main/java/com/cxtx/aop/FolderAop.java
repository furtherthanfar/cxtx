package com.cxtx.aop;

import com.cxtx.site.SiteController;
import com.cxtx.strategy.StrategyController;
import com.cxtx.user.UserController;
import com.cxtx.util.ImageUtil;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@Aspect
public class FolderAop {

    @Pointcut(value = "execution(* com.cxtx.user.UserController.uploadHeadImage(..))")
    public void userImageDirPointCut() {
    }

    @Pointcut(value = "execution(* com.cxtx.site.SiteController.upLoadSitePictures(..))")
    public void sitePicturesDirPointCut() {
    }

    @Pointcut(value = "execution(* com.cxtx.strategy.StrategyController.upLoadImage(..))")
    public void strategyImagesDirPointCut() {
    }

    @Before(value = "userImageDirPointCut()")
    public void makeUserImageDir() {
        File file = new File(ImageUtil.PATH + File.separator + UserController.userImageDirPath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    @Before(value = "sitePicturesDirPointCut()")
    public void makeSiteDirPictures() {
        File file = new File(ImageUtil.PATH + File.separator + SiteController.sitePicDirPath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    @Before(value = "strategyImagesDirPointCut()")
    public void makeStrategyImagesDir(){
        File file = new File(ImageUtil.PATH + File.separator + StrategyController.strategyImageDirPath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }


}
