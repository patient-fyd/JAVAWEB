package com.fyd.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * Author: patient.fyd@gmail.com
 * Date: 2023/12/13  9:14
 * Description:
 */
@WebServlet("/servlet5")
public class Servlet5 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收请求中的参数（键值对）
        // 根据参数名获取单个参数值
        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("userPwd"));

        // 根据参数名获取多个参数值
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));

        // 获取所有的参数名
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String param = parameterNames.nextElement();
            String[] parameterValues = req.getParameterValues(param);
            if (parameterValues.length > 1) {
                System.out.println("param = " + param + "  " + Arrays.toString(parameterValues));
            } else {
                System.out.println(param + " = " + parameterValues[0]);
            }
        }

        // 返回所有参数的map集合
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            String key = entry.getKey();
            String[] value = entry.getValue();
            if (value.length > 1) {
                System.out.println("key = " + key + "  " + Arrays.toString(value));
            } else {
                System.out.println(key + " = " + value[0]);
            }
        }

    }
}
