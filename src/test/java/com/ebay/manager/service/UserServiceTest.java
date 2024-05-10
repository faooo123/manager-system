package com.ebay.manager.service;

import com.ebay.manager.entity.UserAccessInfo;
import com.ebay.manager.entity.UserAuthInfo;
import com.ebay.manager.utils.ThreadLocalUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void addUserTest(){
        ThreadLocalUtil.setUserAuthInfo(new UserAuthInfo("112233", "XXXXXX", "user"));
        userService.checkResource("resource A");
    }
}
