package com.cxtx.account;

import com.cxtx.user.User;
import com.cxtx.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountMapper;
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
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
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUp(@RequestBody User user, @RequestBody Account account) {
        // 把用户和账户信息加入数据库
        userService.insertAccountAndUser(account, user);
        return "Welcome  User :" + user.getNickName();
    }


}
