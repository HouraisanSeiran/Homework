package com.example.class01servlet;

import jakarta.servlet.*;

import java.io.IOException;

public class ServletDemo1 implements Servlet {
    /**
     * Servlet 初始化
     * @param servletConfig
     * @throws ServletException
     */

    @Override
    public void init(ServletConfig servletConfig)throws ServletException {
        System.out.println("Servlet 启动！！！");
    }

    /**
     * 执行配置
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().write("servletDemo1 启动");
        System.out.println("service 执行");
    }

    /**
     * 获取service信息
     * @return
     */
    @Override
    public String getServletInfo() {
        return "";
    }

    /**
     * 执行销毁方法
     */
    @Override
    public void destroy() {
        System.out.println("销毁方法");
    }
}
