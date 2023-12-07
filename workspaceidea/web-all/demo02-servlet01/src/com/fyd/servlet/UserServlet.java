package com.fyd.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


/**
 * servlet 开发流程
 * 1 创建javaweb项目，同时将tomcat插入到项目中，创建servlet，创建一个类继承HttpServlet
 * 2 重写service方法，
 * 3 在service方法中，定义业务处理代码
 * 4 在web.xml中，配置Servl路径
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1 从request对象中获取请求的任何信息
        String username = req.getParameter("username");

        String INFO = "YES";
        // 2 处理业务的代码
        if (!username.equals("fyd")) {
            INFO = "NO";
        }

        PrintWriter writer = resp.getWriter();
        writer.write(INFO);
    }
}
