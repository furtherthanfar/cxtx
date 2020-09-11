package com.cxtx.aop;

import com.cxtx.site.SiteController;
import com.cxtx.user.UserController;
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

    @Before(value = "userImageDirPointCut()")
    public void makeUserImageDir() {
        File file = new File(UserController.userImageDirPath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    @Before(value = "sitePicturesDirPointCut()")
    public void makeSitePictures() {
        File file = new File(SiteController.sitePicDirPath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }


}
