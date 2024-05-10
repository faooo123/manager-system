package com.ebay.manager.service;

import com.ebay.manager.entity.UserAccessInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminServiceTest {
    @Autowired
    AdminService adminService;

    @Test
    public void addUserTest(){
        List<String> endpoint = new ArrayList<>();
        endpoint.add("resource A");
        endpoint.add("resource B");
        endpoint.add("resource C");
        UserAccessInfo userAccessInfo = new UserAccessInfo("112233", endpoint);
        adminService.addUser(userAccessInfo);
    }
}
