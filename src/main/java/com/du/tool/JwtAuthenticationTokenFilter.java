
package com.du.tool;/*

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by dcy on 2018/1/12.
 *//*

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {



    @Autowired
    private JwtTokenUtil JwtTokenUtil;

    private String tokenHeader="Token";

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain) throws ServletException, IOException {
        String authHeader = request.getHeader(this.tokenHeader);
        if(JwtTokenUtil.parseJWT(authHeader)){
            System.out.println("验证成功");
        }else {
            System.out.println("验证失败");
        }
        chain.doFilter(request, response);

    }
}*/
    @Component
public class JwtAuthenticationTokenFilter extends HandlerInterceptorAdapter {

    /**
     * 前置检查
     */
    @Autowired
    private JwtTokenUtil JwtTokenUtil;
    private String tokenHeader="token";
    int i=0;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        /*String ip = request.getRemoteAddr();
        String url = request.getRequestURL().toString();
        long startTime = System.currentTimeMillis();
        request.setAttribute("requestStartTime", startTime);
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 获取用户token
        Method method = handlerMethod.getMethod();
        System.out.println("请求路径："+url+"用户:"+ip+",访问目标:"+method.getDeclaringClass().getName() + "." + method.getName());*/
        String authHeader = request.getHeader(this.tokenHeader);
        String method = request.getMethod();
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
       /* if(method=="OPTIONS"){
            System.out.println("token为空");
            return true;
        }if(authHeader==null&&authHeader==""){

            return false;
        }else {
            System.out.println(authHeader);
            if (JwtTokenUtil.parseJWT(authHeader)) {
                System.out.println("验证成功");
                return true;
            } else {
                System.out.println("验证失败");
                return false;
            }
        }

        }*/
        i++;
        System.out.println(i);
        if (authHeader == null&&method=="OPTIONS") {
            System.out.println("weikong");
            return true;
        }
        if(authHeader==null){
            return false;
        }
        if (authHeader != null) {
            System.out.println("buweikong");
            System.out.println(authHeader);
            if (JwtTokenUtil.parseJWT(authHeader)) {
                System.out.println("验证成功");
                return true;
            } else {
                System.out.println("验证失败");
                return false;
            }
        }
        return true;
    }




    // controller处理完成

}