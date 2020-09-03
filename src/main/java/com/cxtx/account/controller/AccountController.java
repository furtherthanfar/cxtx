package com.cxtx.account.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AccountController {

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest request){
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        if("123".equals(userName) && "456".equals(passWord)){
            return "success";
        }
        return "false";

    }

}
