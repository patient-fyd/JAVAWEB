package com.fyd.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Author: patient.fyd@gmail.com
 * @Description:
 * @DateTime: 2023/12/23 23:22
 */
public class ServletB extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求中携带的cookie
        Cookie[] cookies = req.getCookies();
        // 请求中的多个cookie会进入该数组 请求中如果没有cookie,数组为null
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + ":" + cookie.getValue());
            }
        }
    }
}
