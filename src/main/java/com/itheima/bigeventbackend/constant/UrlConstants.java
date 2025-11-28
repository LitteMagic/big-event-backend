package com.itheima.bigeventbackend.constant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Url静态常量
 */
public final class UrlConstants {
    public static final String USER_URL = "/user";
    public static final String LOGIN_URL = USER_URL + "/login";
    public static final String REGISTER_URL = USER_URL + "/register";

//    不被登录蓝机器拦截的URL list
    public static final List<String> EXCLUDE_FROM_LOGIN_INTERCEPTOR =
            Collections.unmodifiableList(Arrays.asList(LOGIN_URL,USER_URL));


}
