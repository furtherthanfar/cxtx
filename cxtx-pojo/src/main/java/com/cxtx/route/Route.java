package com.cxtx.route;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author
 * @Date 2020/9/15
 * @Description 路线
 */
@Data
@Component
@Scope(scopeName = "prototype")
public class Route {
    // 路线 ID
    private int id;
    // 路线名称
    private String name;
    // 路线描述
    private String description;
    // 各个景点
    private List<RouteSite> routeSites;


}
