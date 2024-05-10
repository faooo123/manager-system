package com.ebay.manager.service.impl;

import com.ebay.manager.dto.request.AddUserRequest;
import com.ebay.manager.entity.UserAccessInfo;
import com.ebay.manager.exception.ApplicationErrorCode;
import com.ebay.manager.exception.ApplicationException;
import com.ebay.manager.service.AdminService;
import com.ebay.manager.utils.FileUtil;
import com.ebay.manager.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class IAdminServiceImpl implements AdminService {

    @Override
    public void addUser(UserAccessInfo userAccessInfo) {
        URL resource = getClass().getClassLoader().getResource("access_info.json");
        File file = new File(resource.getFile());
        FileUtil.checkFile(file);

        try {
            String accessInfoStr = FileUtil.readFile(file);

            Map<String, List<String>> userAccessInfoMap = null;
            if(StringUtils.isEmpty(accessInfoStr)){
                userAccessInfoMap = new HashMap<>();
            }else {
                userAccessInfoMap = (Map<String, List<String>>)JsonUtil.toObject(accessInfoStr, Map.class);
            }

            userAccessInfoMap.put(userAccessInfo.getUserId(), userAccessInfo.getEndpoint());

            FileUtil.writeFile(JsonUtil.toJSON(userAccessInfoMap), file, false);
        } catch (Exception e) {
            log.error("", e);
            throw new ApplicationException(ApplicationErrorCode.UNKNOWN_ERROR);
        }
    }
}
