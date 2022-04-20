package com.dry.admin.interceptor;

import com.dry.admin.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 1.配置好拦截器要拦截的请求
 * 2.把这些配置放在容器中
 *
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //查看拦截的路径
        String requestURI = request.getRequestURI();
        log.info("拦截的请求路径是{}",requestURI);

        //获取session中是否有登录用户信息
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");

        //拦截逻辑判断
        if(loginUser != null){
            return true;
        } else {
            request.setAttribute("message", "请重新登录");
            request.getRequestDispatcher("/").forward(request, response);
            return false;
        }
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle执行{}", modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion方法执行异常{}", ex);
    }
}
