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
 */

@WebServlet(value = "/ServletLifeCycle",loadOnStartup = -1)
public class ServletLifeCycle2 extends HttpServlet {

    public ServletLifeCycle2() {
        System.out.println("构造器2");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("初始化2");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("服务2");
    }

    @Override
    public void destroy() {
        System.out.println("销毁2");
    }

}
