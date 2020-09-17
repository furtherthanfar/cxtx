package com.cxtx.route;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lqk
 * @Date 2020/9/15
 * @Description
 */
@Api(tags = "路线相关控制器")
@Controller
@RequestMapping(value = "/route")
public class RouteController {
    @Autowired
    private RouteService routeService;

    @ApiOperation(value = "查找所有的路线")
    @RequestMapping(value = "/getAllRoutes", method = RequestMethod.GET)
    @ResponseBody
    public List<Route> getAllRoutes(){
        return routeService.selectAllRoutes();
    }

    @ApiOperation(value = "插入一条新的路线")
    @RequestMapping(value = "/insertNewRoute", method = RequestMethod.POST)
    @ResponseBody
    public String insertNewRoute(@RequestBody Route route){
        routeService.insertNewSite(route);
        return "success";
    }
}
