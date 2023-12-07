package com.fyd.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


/*
 * servlet 开发流程
 * 1 创建javaWeb项目，同时将tomcat插入到项目中，创建servlet，创建一个类继承HttpServlet
 * 2 重写service方法，
 * 3 在service方法中，定义业务处理代码
 * 4 在web.xml中，配置Servlet路径
 *
 * 1 servlet-api.jar 导入问题
 *      编码的时候需要，运行的时候，在服务器环境中，由服务软件提供
 *      因此，我们项目中在打包的时候，无需携带这个jar包。
 * 2 Content-Type 响应头问题
 *      MIME类型响应头  媒体类型，文件类型，响应的数据类型
 *      MIME类型用于告诉客户端响应的数据是什么类型的数据，客户端以此决定怎么解析文件
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1 从request对象中获取请求的任何信息
        String username = req.getParameter("username");

        String INFO = "<h1>校验成功</h1>";
        // 2 处理业务的代码
        if (!username.equals("fyd")) {
            INFO = "<h1>校验失败</h1>";
        }

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write(INFO);

    }
}
