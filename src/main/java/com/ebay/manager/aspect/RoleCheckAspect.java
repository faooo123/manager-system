package com.ebay.manager.aspect;

import com.ebay.manager.annotation.RoleCheck;
import com.ebay.manager.entity.UserAuthInfo;
import com.ebay.manager.exception.ApplicationErrorCode;
import com.ebay.manager.exception.ApplicationException;
import com.ebay.manager.utils.ThreadLocalUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RoleCheckAspect {
    @Before("@annotation(com.ebay.manager.annotation.RoleCheck)")
    public void beforeAdvice(JoinPoint joinPoint){
        UserAuthInfo userAuthInfo = ThreadLocalUtil.getUserAuthInfo();
        if(userAuthInfo == null) throw new ApplicationException(ApplicationErrorCode.AUTH_ERROR);

        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        RoleCheck annotation = signature.getMethod().getAnnotation(RoleCheck.class);
        String role = annotation.role();
        if(!role.equals(userAuthInfo.getRole())) throw new ApplicationException(ApplicationErrorCode.AUTH_ERROR);
    }
}
