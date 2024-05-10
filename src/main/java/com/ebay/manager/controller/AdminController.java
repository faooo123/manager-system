package com.ebay.manager.controller;

import com.ebay.manager.annotation.RoleCheck;
import com.ebay.manager.dto.Response;
import com.ebay.manager.dto.request.AddUserRequest;
import com.ebay.manager.service.AdminService;
import com.ebay.manager.utils.ResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/addUser")
    @RoleCheck
    public ResponseEntity<Response> addUser(@RequestBody AddUserRequest addUserRequest){
        addUserRequest.valid();
        adminService.addUser(addUserRequest.convertToUserAccessInfo());
        return ResponseGenerator.genSuccessResult();
    }
}
