package com.ebay.manager.service;

import com.ebay.manager.dto.request.AddUserRequest;
import com.ebay.manager.entity.UserAuthInfo;
import com.ebay.manager.utils.Base64Util;
import com.ebay.manager.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class UserContronllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void checkResourceTest(){
        UserAuthInfo admin = new UserAuthInfo("112233", "XXXXXX", "user");
        String resource = "resource A";
        try {
            ResultActions ra = mockMvc.perform(MockMvcRequestBuilders
                    .get("/user/" + resource)
                    .header("roleinfo", Base64Util.encode(JsonUtil.toJSON(admin)))
            );
            ra.andReturn().getResponse().setCharacterEncoding("UTF-8");
            ra.andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
