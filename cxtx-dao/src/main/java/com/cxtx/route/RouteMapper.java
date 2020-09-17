package com.cxtx.route;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lqk
 * @Date 2020/9/15
 * @Description 路线相关 Mapper
 */
@Mapper
@Repository
public interface RouteMapper {
    /**
     * 插入路线
     * @param route
     * @return
     */
    public int insertRoute(Route route);

    /**
     * 插入路线-景点对应关系
     * @param routeSites
     * @return
     */
    public int insertRouteSites(List<RouteSite> routeSites);

    /**
     * 查找所有的路线
     * @return
     */
    public List<Route> selectAllRoutes();

    /**
     * 根据 路线ID 查找出路线-景点 对应
     * @param route_id
     * @return
     */
    public List<RouteSite> selectRouteSiteByRid(int route_id);
}
