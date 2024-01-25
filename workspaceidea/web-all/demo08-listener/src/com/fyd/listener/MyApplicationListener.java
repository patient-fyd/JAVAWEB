package com.fyd.listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;

/**
 * Author: patient.fyd@gmail.com
 * Date: 2024/1/25  17:13
 * Description:
 */
@WebListener
public class MyApplicationListener implements ServletContextListener, ServletContextAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        System.out.println(application.hashCode() + "应用域初始化了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        System.out.println(application.hashCode() + "应用域销毁了");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        ServletContext application = scae.getServletContext();
        String name = scae.getName();
        Object value = scae.getValue();
        System.out.println(application.hashCode() + "应用域增加了"+name+":"+value);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        ServletContext application = scae.getServletContext();
        String name = scae.getName();
        Object value = scae.getValue(); // 获取的是旧的值
        Object newValue = application.getAttribute(name); // 获取的是新的值
        System.out.println(application.hashCode() + "应用域修改成了"+name+":"+newValue);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        ServletContext application = scae.getServletContext();
        String name = scae.getName();
        Object value = scae.getValue();
        System.out.println(application.hashCode() + "应用域移除了"+name+":"+value);
    }
}
