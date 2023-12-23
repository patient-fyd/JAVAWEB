package com.fyd.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @Author: patient.fyd@gmail.com
 * @Description:
 * @DateTime: 2023/12/24 1:57
 */
@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收请求中的username参数
        String username = req.getParameter("username");

        // 获得session对象
        HttpSession session = req.getSession();
        // 判断请求中有没有一个特殊的cookie JSESSIONID
            // 如果有，根据JSESSIONID在服务端找对应的seesion
            // 如果没有，创建一个新的session返回，并且想response对象中存放一个JSESSIONID的cookie
        System.out.println(session.getId());
        System.out.println(session.isNew());

        // 将uername存入session
        session.setAttribute("username", username);

        // 客户端响应请求
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("登录成功");
    }
}
