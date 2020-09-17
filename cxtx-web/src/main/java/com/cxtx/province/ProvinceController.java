package com.cxtx.province;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(tags = "省份-城市控制器")
@Controller
@RequestMapping(value = "/province")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @ApiOperation(value = "获得所有的省-市信息")
    @RequestMapping(value = "/getAllProvinces", method = RequestMethod.GET)
    @ResponseBody
    public List<Province> getAllProvinces(){
        return provinceService.selectAllProvinces();
    }
}
