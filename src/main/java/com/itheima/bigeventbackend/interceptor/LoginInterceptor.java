package com.itheima.bigeventbackend.interceptor;

import com.itheima.bigeventbackend.pojo.LoginUser;
import com.itheima.bigeventbackend.utils.JwtUtil;
import com.itheima.bigeventbackend.utils.UserContextUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

/**
 * 登录拦截器，拦截登录相关请求
 */

@Component
public class LoginInterceptor implements HandlerInterceptor {

//    在请求处理之前调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        1.验证令牌
        String token = request.getHeader("Authorization");
        try {
            Map<String, Object> claims = JwtUtil.parseToken(token); //解析token，如果token失败，那么此句会抛出异常
            if (claims != null){
//                将 JWT 中的载体存放入线程中
                UserContextUtil.set(new LoginUser(claims));
            }
//            返回真，表示放行
            return true;
        } catch (Exception e) {
            response.setStatus(401);
            e.printStackTrace();
//            返回假，表示不放行
            return false;
        }
    }
//  在请求结束之后调用
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//        清除 ThreadLocal 中的数据
        UserContextUtil.remove();
    }
}
