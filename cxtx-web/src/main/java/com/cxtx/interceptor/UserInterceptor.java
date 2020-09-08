package com.cxtx.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截器
 */
public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 判断当前的会话是否过期
        HttpSession session = request.getSession();
        String user_id;

        if ((user_id = (String) session.getAttribute("user_id")) == null) {
            response.sendRedirect("/toSignUp");
            return false;
        }

        return true;
    }


}
