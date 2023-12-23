package com.fyd.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Author: patient.fyd@gmail.com
 * @Description:
 * @DateTime: 2023/12/23 21:28
 */
@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建cookie
        Cookie cookie1 = new Cookie("keyA", "valueA");
        // 设置cookie持久化时间
        //cookie1.setMaxAge(60 * 5); // 设置cookie有效时间为5分钟
        // 设置cookie请求指定路径
        cookie1.setPath("/servletB");
        Cookie cookie2 = new Cookie("keyB", "valueB");
        // 将cookie放入response对象
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
    }
}
