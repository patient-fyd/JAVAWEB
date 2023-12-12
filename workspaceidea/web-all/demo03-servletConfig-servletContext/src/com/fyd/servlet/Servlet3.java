package com.fyd.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Author: patient.fyd@gmail.com
 * Date: 2023/12/12  10:27
 * Description:
 */
@WebServlet("/servlet3")
public class Servlet3 extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        // 获得一个指向项目部署位置下的某个文件的磁盘只是路径的API
        String path = servletContext.getRealPath("upload");
        System.out.println(path);

        // 获得项目部署的上下文路径，项目的访问路径
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);
    }
}
