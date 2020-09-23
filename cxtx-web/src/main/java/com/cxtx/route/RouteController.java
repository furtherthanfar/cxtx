package com.cxtx.route;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lqk
 * @Date 2020/9/15
 * @Description
 */
@Api(tags = "路线相关控制器")
@RestController
@RequestMapping(value = "/route")
public class RouteController {
    @Autowired
    private RouteService routeService;

    @ApiOperation(value = "查找所有的路线")
    @RequestMapping(value = "/getAllRoutes", method = RequestMethod.GET)
    public List<Route> getAllRoutes(){
        return routeService.selectAllRoutes();
    }

    @ApiOperation(value = "插入一条新的路线")
    @RequestMapping(value = "/insertNewRoute", method = RequestMethod.POST)
    public String insertNewRoute(@RequestBody Route route){
        routeService.insertNewSite(route);
        return "success";
    }

    @ApiOperation(value = "根据ID删除路线")
    @PostMapping(value = "/deleteById")
    public String deleteById(int route_id) {
        routeService.deleteByRouteId(route_id);
        return "success";
    }
}
