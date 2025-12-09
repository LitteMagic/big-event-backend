package com.itheima.bigeventbackend.anno;

import com.auth0.jwt.interfaces.Payload;
import com.itheima.bigeventbackend.validation.StateValdation;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Documented
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {StateValdation.class}) //指定提供校验逻辑的类
public @interface StateValdate {
//    提供校验失败后的提示信息
    String message() default "状态数据不符合规范";
//    指定分组
    Class<?>[] groups() default {};
//    负载 获取到State注解的附加信息
    Class<? extends Payload>[] payload() default {};
}
