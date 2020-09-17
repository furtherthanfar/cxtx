package com.cxtx.route;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author lqk
 * @Date 2020/9/15
 * @Description 路线-景点对应
 */
@Data
@Component
@Scope(scopeName = "prototype")
public class RouteSite {

    // 路线 ID
    private int route_id;
    // 景点 ID
    private int site_id;
    // 排序号码
    private int rank_num;

}
