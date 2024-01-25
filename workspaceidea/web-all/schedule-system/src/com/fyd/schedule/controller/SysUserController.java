package com.fyd.schedule.controller;

import com.fyd.schedule.pojo.SysUser;
import com.fyd.schedule.service.SysUserService;
import com.fyd.schedule.service.impl.SysUserServiceImpl;
import com.fyd.schedule.util.MD5Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
     * 注册时，接收要注册的用户名，校验用户名是否被占用的业务接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkUsernameUsed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收用户名
        String username = req.getParameter("username");

        // 调用服务层业务处理方法查询该该用户名是否有对应的用户
        SysUser sysUser = sysUserService.findByUsername(username);

        // 如果有，响应已占有
        String info = "可用";
        if (null != sysUser){
            info = "已占用";
        }

    }

    /**
     * 接收用户登录请求，完成登录业务接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收用户名和密码
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");

        // 调用服务层方法
        // 根据用户名查询用户信息
        SysUser loginUser = sysUserService.findByUsername(username);
        if (null == loginUser){
            // 跳转到用户名有误提示页
            resp.sendRedirect("/loginUsernameError.html");
        } else if (MD5Util.encrypt(userPwd).equals(loginUser.getUserPwd())) {
            // 判断密码是否匹配
            // 跳转到密码有误提示页
            resp.sendRedirect("/loginUserPwdError.html");
        } else {
            // 登录成功后，将登录的用户信息放入session
            HttpSession session = req.getSession();
            session.setAttribute("sysUser", loginUser);
            // 跳转到登录成功提示页
            resp.sendRedirect("/showSchedule.html");
        }
    }

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
