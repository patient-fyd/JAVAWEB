package com.fyd.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Author: patient.fyd@gmail.com
 * Date: 2023/12/11  14:25
 * Description:
 * 1 实例化    构造器     第一次请求
 * 2 初始化    init        构造关闭
 * 3 接收请求，处理请求 服务   service     每次请求
 * 4 销毁     destory     关闭服务
 *
 * Servlet在Tomcat是单例的
 *
 */

@WebServlet(value = "/ServletLifeCycle2",loadOnStartup = 2)
public class ServletLifeCycle extends HttpServlet {

    public ServletLifeCycle() {
        System.out.println("构造器");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("初始化");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("服务");
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }

}
