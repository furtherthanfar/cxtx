package com.cxtx.account;

import com.cxtx.user.User;
import com.cxtx.user.UserService;
import com.cxtx.util.ContextUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Api(tags = "帐号相关控制器")
@Controller
@RequestMapping(value = "/sign")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private UserService userService;

    /**
     * 前往注册界面
     * @return
     */
    @ApiOperation(value = "去注册界面")
    @GetMapping("/toSignUp")
    public String toSighUp(){
        return "signUp";
    }


    /**
     * 登录已有的账户
     * @param request
     * @return
     */
    @ApiOperation(value = "登录")
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        Account account = null;
        if ((account = accountService.selectAccount(userName, passWord)) != null) {
            // 登录成功，把用户的 id 存放进 session 域
            request.getSession().setAttribute("user_id",account.getUser_id());
            // Session 10 分钟过期
            request.getSession().setMaxInactiveInterval(10 * 60);
            return "success";
        }
        return "failure";
    }


    @ApiOperation(value = "注册新的用户")
    /**
     * 注册新的用户
     * @param userName 用户名
     * @param password 密码
     * @param nickName 网名
     * @param gender 性别
     * @param birth 生日
     * @param description 描述
     * @param phoneNumber 电话号码
     * @param email 邮箱
     * @param career 职业
     * @param realName 真实姓名
     * @param head 头像地址
     * @param cityName 城市名称
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/signUp",method = RequestMethod.POST)
    public String signUp(String userName,String password,
                         String nickName,String gender,
                         @Nullable Date birth,
                         @Nullable String description,
                         String phoneNumber,
                         @Nullable String email,
                         @Nullable String career,
                         @Nullable String realName,
                         String head,
                         String cityName) {
        // 组装新的account
        Account account = (Account) ContextUtil.getBean("account");
        account.build(0, userName, password, 0);
        // 组装新的user
        User user = (User) ContextUtil.getBean("user");
        user.build(0, nickName, gender,
                birth, description, phoneNumber,
                email, career, realName,
                head, cityName);
        // 把用户和账户信息加入数据库
        userService.insertAccountAndUser(account, user);
        return "success";
    }


    /**
     * 修改登录密码
     * @param originalPswd 原密码
     * @param newPswd 新密码
     * @param session
     * @return
     */
    @ApiOperation(value = "修改登录密码")
    @RequestMapping(value = "alterPassWord", method = RequestMethod.POST)
    @ResponseBody
    public String alterPassWord(String originalPswd, String newPswd, HttpSession session){
        int user_id = (int) session.getAttribute("user_id");
        Account account = accountService.selectAccountByUserId(user_id);
        // 原密码错误
        if(!account.getPassWord().equals(originalPswd)){
            return "failure";
        }
        // 修改成功
        accountService.updatePassWord(account.getUser_id(), newPswd);
        return "success";
    }


}
