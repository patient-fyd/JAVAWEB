package com.fyd.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * Author: patient.fyd@gmail.com
 * Date: 2023/12/13  8:51
 * Description:
 */
@WebServlet("/servlet4")
public class Servlet4 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 行相关 GET/POST
        System.out.println(req.getMethod());    // 获取请求方式
        System.out.println(req.getScheme());    // 获取请求协议
        System.out.println(req.getProtocol());  // 获取请求协议及版本
        System.out.println(req.getRequestURI());    // 获取请求的uri 项目内的资源路径
        System.out.println(req.getRequestURL());    // 获取请求的url 项目内资源完成的路径
        /*
        * URI   统一资源标识符   /demo03/a.html   interface URI{}
        * URL   统一资源定位符   http://localhost:8080/demo03/a.html   class URL implements URI{}
        * */

        System.out.println(req.getLocalPort());    // 获取本应用容器的端口号
        System.out.println(req.getServerPort());    // 客户端发请求时使用的端口号
        System.out.println(req.getRemotePort());    // 客户端软件的端口号

        // 根据名字单独获取某个请求头
        String accept = req.getHeader("Accept");
        System.out.println("Accept = " + accept);

        // 获取所有请求头的名字
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            System.out.println("header = " + header);
        }
    }
}
