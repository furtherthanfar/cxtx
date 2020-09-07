package com.cxtx.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountMapper;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request){
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        if(accountMapper.selectAccount(userName,passWord) != null){
            return "success";
        }
        return "false";

    }

    @ResponseBody
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUp(HttpServletRequest request){
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        accountMapper.insertAccount(new Account(userName,passWord,0));
        return "Welcome  User :" + userName;
    }



}
