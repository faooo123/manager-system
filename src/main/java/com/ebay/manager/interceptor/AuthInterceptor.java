package com.ebay.manager.interceptor;

import com.ebay.manager.entity.UserAuthInfo;
import com.ebay.manager.exception.ApplicationErrorCode;
import com.ebay.manager.exception.ApplicationException;
import com.ebay.manager.utils.Base64Util;
import com.ebay.manager.utils.JsonUtil;
import com.ebay.manager.utils.ThreadLocalUtil;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor extends HandlerInterceptorAdapter {
    private static String ROLE_INFO_KEY = "roleinfo";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        String roleInfoBase64Str = request.getHeader(ROLE_INFO_KEY);
        if(roleInfoBase64Str == null) throw new ApplicationException(ApplicationErrorCode.AUTH_ERROR);

        String roleInfoStr = Base64Util.decode(roleInfoBase64Str);
        UserAuthInfo userAuthInfo = JsonUtil.toObject(roleInfoStr, UserAuthInfo.class);
        ThreadLocalUtil.setUserAuthInfo(userAuthInfo);

        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        ThreadLocalUtil.clear();
        super.afterCompletion(request, response, handler, ex);
    }
}
