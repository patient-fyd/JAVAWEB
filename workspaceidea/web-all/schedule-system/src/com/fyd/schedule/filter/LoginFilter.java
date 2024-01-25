package com.fyd.schedule.filter;

import com.fyd.schedule.pojo.SysUser;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Author: patient.fyd@gmail.com
 * Date: 2024/1/25  19:02
 * Description:
 */
@WebFilter(urlPatterns = {"/showSchedule.html", "/schedule/*"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 参数父转子
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 获得session域对象
        HttpSession session = request.getSession();
        // 从session域中获得登录的用户对象
        SysUser sysUser = (SysUser) session.getAttribute("sysUser");

        // 判断用户对象是否为空
        if (null == sysUser) {
            // 如果为空，表示用户没有登录，跳转到登录页面
            response.sendRedirect("/login.html");
        } else {
            // 如果不为空，表示用户已经登录，放行
            filterChain.doFilter(request, response);
        }
    }
}
