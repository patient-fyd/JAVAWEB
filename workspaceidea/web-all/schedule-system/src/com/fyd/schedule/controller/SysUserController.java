package com.fyd.schedule.controller;

import com.fyd.schedule.pojo.SysUser;
import com.fyd.schedule.service.SysUserService;
import com.fyd.schedule.service.impl.SysUserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Author: patient.fyd@gmail.com
 * Date: 2023/12/19  10:21
 * Description:
 */
@WebServlet("/user/*")
public class SysUserController extends BaseController {

    private SysUserService sysUserService = new SysUserServiceImpl();

    /**
     * 接收用户注册请求的业务处理方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收客户端提交的参数
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        // 调用服务层方法，完成注册功能
        // 将参数放入应该sysUser对象中，在调用regist方法时传入
        SysUser sysUser = new SysUser(null,username,userPwd);
        int rows = sysUserService.regist(sysUser);
        if (rows > 0) {
            resp.sendRedirect("/registSuccess.html");
        } else {
            resp.sendRedirect("/registFail.html");
        }
        // 根据注册结果，跳转页面
    }
}
