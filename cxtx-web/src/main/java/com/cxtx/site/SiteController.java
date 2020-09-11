package com.cxtx.site;

import com.cxtx.util.ContextUtil;
import com.cxtx.util.ImageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Api(tags = "景区信息相关")
@Controller
@RequestMapping(value = "/site")
@Slf4j
public class SiteController {

    @Autowired
    private SiteService siteService;
    @Autowired
    private ImageUtil imageUtil;
    // 景点图片储存文件夹
    public static String sitePicDirPath = "D:" + File.separator + "cxtx" + File.separator + "sitePictures";

    @ApiOperation(value = "根据景点ID获得景点信息")
    @ResponseBody
    @RequestMapping(value = "/getSite", method = RequestMethod.POST)
    public Site getSite(int site_id) {
        return siteService.selectSiteById(site_id);
    }


    @ApiOperation(value = "获取所有的景点信息")
    @ResponseBody
    @RequestMapping(value = "/getAllSites", method = RequestMethod.GET)
    public List<Site> getAllSites() {
        return siteService.selectAllSites();
    }


    @ApiOperation(value = "上传一组景点图片")
    @ResponseBody
    @RequestMapping(value = "/upLoadSitePictures", method = RequestMethod.POST)
    public List<String> upLoadSitePictures(MultipartFile[] pictures) {
        // 检查文件格式，如果不合适，直接返回 "failure"
        for (MultipartFile file : pictures) {
            if (!imageUtil.isImageLegal(file.getOriginalFilename())) {
                log.debug("景区图片格式错误");
                return null;
            }
        }

        // 图片命名计数器
        AtomicInteger imageInteger = (AtomicInteger) ContextUtil.getBean("sitePictureInteger");
        // 保存每一个文件路径
        List<String> list = new ArrayList<>();
        String filePath = null;
        // 分别保存各个文件
        for (MultipartFile file : pictures) {
            String[] split = file.getOriginalFilename().split("\\.");
            // 获得图片编码名称 + 位置
            filePath = sitePicDirPath + File.separator + getSitePicName(imageInteger) + "." +  split[split.length - 1];
            list.add(filePath);
            File newFile = new File(filePath);
            // 保存图片
            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
                log.debug("异常");
                return null;
            }
        }
        log.debug("正常返回");
        return list;
    }

    /**
     * 添加一个新的景点
     *
     * @param site
     * @return
     */
    @ApiOperation(value = "添加一个新的景点", notes = "标签")
    @ResponseBody
    @RequestMapping(value = "/addNewSite", method = RequestMethod.POST)
    public String addNewSite(@RequestBody Site site) {
        if (siteService.insertSite(site) > 0) {
            return "success";
        }
        return "failure";
    }


    /**
     * 获得头像的编码
     *
     * @return
     */
    public String getSitePicName(AtomicInteger sitePicInteger) {
        int number = sitePicInteger.incrementAndGet();
        // 根据当前日期，获得头像编码的一部分
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) ContextUtil.getBean("simpleDateFormat");
        Date date = (Date) ContextUtil.getBean("date");
        // 根据递增数字，获得头像编码的一部分
        String numberString = String.format("%05d", number);
        String result = "sitePicture-" + simpleDateFormat.format(date) + numberString;
        return result;
    }
}
