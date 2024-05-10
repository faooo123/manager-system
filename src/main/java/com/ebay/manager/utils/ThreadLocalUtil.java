package com.ebay.manager.utils;

import com.ebay.manager.entity.UserAuthInfo;

public class ThreadLocalUtil {
    private static final ThreadLocal<UserAuthInfo> CONTEXT_HOLDER = ThreadLocal.withInitial(UserAuthInfo::new);

    public static UserAuthInfo getUserAuthInfo(){
        return CONTEXT_HOLDER.get();
    }

    public static void clear() {
        CONTEXT_HOLDER.remove();
    }

    public static void setUserAuthInfo(UserAuthInfo userAuthInfo){
        CONTEXT_HOLDER.set(userAuthInfo);
    }
}
