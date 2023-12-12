package com.fyd.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * Author: patient.fyd@gmail.com
 * Date: 2023/12/12  9:40
 * Description:
 */
@WebServlet(
        urlPatterns = "/servlet2",
        initParams = {
                @WebInitParam(name = "keya", value = "value2A"),
                @WebInitParam(name = "keyb", value = "value2B")
        }
)
public class Servlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        // 获取初始配置信息即可
        // 根据参数名获取参数值
        String keya = servletConfig.getInitParameter("keya");
        System.out.println("keya = " + keya);

        // 获取所有的初始参数的名字
        // hasMoreElements() 判断有没有下一个参数，如果有返回true
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();

        while (initParameterNames.hasMoreElements()) {
            String param = initParameterNames.nextElement();
            System.out.println("param = " + param);
        }
    }
}
