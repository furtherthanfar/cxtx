package com.cxtx.strategy;

import com.cxtx.user.User;
import com.cxtx.user.UserService;
import com.cxtx.util.ContextUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author lqk
 * @Date 2020/9/18
 * @Description
 */
@Api(tags = "攻略相关控制器")
@RestController
@RequestMapping(value = "/strategy")
public class StrategyController {

    @Autowired
    private StrategyService strategyService;
    @Autowired
    private UserService userService;

    @ApiOperation(value = "插入一个新的攻略")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertStrategy(Date date, String content, HttpServletRequest request){
        Strategy strategy = ContextUtil.getBean("strategy", Strategy.class);
        int user_id = (int) request.getSession().getAttribute("user_id");
        User user = userService.selectUserById(user_id);
        strategy.build(0, date, content, user);
        strategyService.inertStrategy(strategy);
        return "success";
    }

    @ApiOperation(value = "查找出全部的攻略")
    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    public List<Strategy> selectAll(){
        return strategyService.selectAllStrategies();
    }

    @ApiOperation(value = "根据用户ID查找攻略")
    @RequestMapping(value = "/selectByUser", method = RequestMethod.GET)
    public List<Strategy> selectByUserId(HttpServletRequest request){
        int user_id = (int) request.getSession().getAttribute("user_id");
        return strategyService.selectStrategiesByUserId(user_id);
    }

}
