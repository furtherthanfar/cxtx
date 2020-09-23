package com.cxtx.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lqk
 * @Date 2020/9/15
 * @Description
 */
@Service
public class RouteService {

    @Autowired
    private RouteMapper routeMapper;

    /**
     * 插入一条新的路线
     *
     * @param route
     */
    @Transactional
    public void insertNewSite(Route route) {
        // 插入路线，生成主键
        routeMapper.insertRoute(route);
        // 设置路线-景点对应的路线ID
        for (RouteSite routeSite : route.getRouteSites()){
            routeSite.setRoute_id(route.getId());
        }
        // 把对应关系插入数据库
        routeMapper.insertRouteSites(route.getRouteSites());
    }

    /**
     * 查找出所有的路线
     * @return
     */
    public List<Route> selectAllRoutes(){
        return routeMapper.selectAllRoutes();
    }

    /**
     *  根据路线ID删除路线
     * @param route_id
     */
    public void deleteByRouteId(int route_id){
        routeMapper.deleteByRouteId(route_id);
    }

}
