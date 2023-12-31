package com.cy.store_.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 定义拦截器
 * @Auther: hanshihao
 * @Date: 2023/09/10/23:14
 */
public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        // 获取请求URL
//        String url = request.getRequestURL().toString();
//
//        // 获取请求方法
//        String method = request.getMethod();
//
//        // 获取请求参数
//        String queryString = request.getQueryString();
//
//        // 构建 cURL 命令
//        String curlCommand = String.format("curl -X %s %s?%s", method, url, queryString);
//
//        // 打印 cURL 信息到日志
//        logger.info("cURL: {}", curlCommand);
//
//        return true;
//    }





    /**
     * 检测全局session对象中是否有uid数据，如果有则放行，如果没有重定向到登录页面
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 处理器(url + Controller：映射)
     * @return 如果返回true 表示放行，返回false则表示拦截当前请求
     * @throws Exception
     */
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        // HttpServletRequest 来获取 session对象
//        Object uid = request.getSession().getAttribute("uid");
//        if(uid == null){
//            // 说明用户没有登录过系统，则重定向到 login.html 页面
//            response.sendRedirect("/web/login.html");
//            // 结束后续的调用
//            return false;
//        }
//        // 请求放行
//        return true;
//    }


}
