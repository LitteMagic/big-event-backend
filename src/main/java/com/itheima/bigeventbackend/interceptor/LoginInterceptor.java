package com.itheima.bigeventbackend.interceptor;

import com.itheima.bigeventbackend.constant.APIResponseConstants;
import com.itheima.bigeventbackend.pojo.Result;
import com.itheima.bigeventbackend.utils.JwtUtil;
import com.itheima.bigeventbackend.utils.Md5Util;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

/**
 * 登录拦截器，拦截登录相关请求
 */

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        1.验证令牌
        String token = request.getHeader("Authorization");
        try {
            Map<String, Object> claims = JwtUtil.parseToken(token); //解析token，如果token失败，那么此句会抛出异常
//            返回真，表示放行
            return true;
        } catch (Exception e) {
            response.setStatus(401);
            e.printStackTrace();
//            返回假，表示不放行
            return false;
        }
    }
}
