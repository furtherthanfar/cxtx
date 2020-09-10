package com.cxtx.site;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(tags = "景区信息相关")
@Controller
@RequestMapping(value = "/site")
public class SiteController {

    @Autowired
    private SiteService siteService;

    @ApiOperation(value = "根据景点ID获得景点信息")
    @ResponseBody
    @RequestMapping(value = "/getSite", method = RequestMethod.POST)
    public Site getSite(int site_id){
        return siteService.selectSiteById(site_id);
    }

    @ApiOperation(value = "获取所有的景点信息")
    @ResponseBody
    @RequestMapping(value = "/getAllSites", method = RequestMethod.GET)
    public List<Site> getAllSites(){
        return siteService.selectAllSites();
    }


}
