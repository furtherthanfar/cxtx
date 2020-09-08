package com.cxtx.account;

import com.cxtx.user.User;
import com.cxtx.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/sign")
public class AccountController {

    @Autowired
    private AccountService accountMapper;
    @Autowired
    private UserService userService;

    @GetMapping("/toSignUp")
    public String toSighUp(){
        return "signUp";
    }


    /**
     * 登录已有的账户
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        Account account = null;
        if ((account = accountMapper.selectAccount(userName, passWord)) != null) {
            // 登录成功，把用户的 id 存放进 session 域
            request.getSession().setAttribute("user_id",account.getUser_id());
            // Session 10 分钟过期
            request.getSession().setMaxInactiveInterval(10 * 60);
            return "success";
        }
        return "false";

    }

    /**
     * 注册新的账户
     *
     * @param user
     * @param account
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/signUp")
    public String signUp(@RequestBody User user, @RequestBody Account account) {
        // 把用户和账户信息加入数据库
        userService.insertAccountAndUser(account, user);
        return "Welcome  User :" + user.getNickName();
    }




}
