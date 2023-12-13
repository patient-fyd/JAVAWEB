package com.fyd.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author: patient.fyd@gmail.com
 * Date: 2023/12/13  10:34
 * Description:
 */
@WebServlet("/servlet6")
public class Servlet6 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应行相关的API
        resp.setStatus(200);  // 设置状态码

        String info = "<h1>Servlet6</h1>";

        // 设置响应头相关的API
        resp.setHeader("Content-Type", "text/html;charset=utf-8");
        resp.setContentLength(info.getBytes().length);

        // 设置响应体内容的API
        // 获得一个向响应体中输入文本字符输出流
        PrintWriter writer = resp.getWriter();
        writer.write(info);

        // 获得一个向响应体中输入二进制信息的字节输出流
        ServletOutputStream outputStream = resp.getOutputStream();

    }
}
