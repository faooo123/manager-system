package com.ebay.manager.service.impl;

import com.ebay.manager.Application;
import com.ebay.manager.entity.UserAccessInfo;
import com.ebay.manager.entity.UserAuthInfo;
import com.ebay.manager.exception.ApplicationErrorCode;
import com.ebay.manager.exception.ApplicationException;
import com.ebay.manager.service.UserService;
import com.ebay.manager.utils.FileUtil;
import com.ebay.manager.utils.JsonUtil;
import com.ebay.manager.utils.ThreadLocalUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class IUserServiceImpl implements UserService {
    @Override
    public void checkResource(String source) {
        UserAuthInfo userAuthInfo = ThreadLocalUtil.getUserAuthInfo();
        if(userAuthInfo == null || userAuthInfo.getUserId() == null)  throw new ApplicationException(ApplicationErrorCode.AUTH_ERROR);

        URL resource = getClass().getClassLoader().getResource("access_info.json");
        File file = new File(resource.getFile());
        if(!file.exists()) throw new ApplicationException(ApplicationErrorCode.AUTH_ERROR);

        String accessInfoStr = null;
        try {
            accessInfoStr = FileUtil.readFile(file);
        } catch (Exception e) {
            log.error("", e);
        }
        if(StringUtils.isEmpty(accessInfoStr)) throw new ApplicationException(ApplicationErrorCode.AUTH_ERROR);

        Map<String, List<String>> userAccessInfoMap;
        try {
            userAccessInfoMap = (Map<String, List<String>>)JsonUtil.toObject(accessInfoStr, Map.class);
        }catch (Exception e){
            throw new ApplicationException(ApplicationErrorCode.UNKNOWN_ERROR);
        }

        List<String> endpoints = userAccessInfoMap.get(userAuthInfo.getUserId());
        if(endpoints == null || endpoints.isEmpty() || !endpoints.contains(source)){
            throw new ApplicationException(ApplicationErrorCode.AUTH_ERROR);
        }
    }
}
