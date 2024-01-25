package com.fyd.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * Author: patient.fyd@gmail.com
 * Date: 2024/1/25  16:37
 * Description:
 */
@WebFilter("/*")
public class Filter2 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Filter2 before");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Filter2 after");
    }
}
