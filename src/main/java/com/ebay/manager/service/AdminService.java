package com.ebay.manager.service;

import com.ebay.manager.dto.request.AddUserRequest;
import com.ebay.manager.entity.UserAccessInfo;

public interface AdminService {
    void addUser(UserAccessInfo userAccessInfo);
}
