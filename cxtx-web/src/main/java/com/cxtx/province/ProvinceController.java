package com.cxtx.province;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/province")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @RequestMapping(value = "/getAllProvinces")
    @ResponseBody
    public List<Province> getAllProvinces(){
        return provinceService.selectAllProvinces();
    }
}
