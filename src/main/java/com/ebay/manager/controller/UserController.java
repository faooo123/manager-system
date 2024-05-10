package com.ebay.manager.controller;

import com.ebay.manager.annotation.RoleCheck;
import com.ebay.manager.dto.Response;
import com.ebay.manager.exception.ApplicationErrorCode;
import com.ebay.manager.exception.ApplicationException;
import com.ebay.manager.service.UserService;
import com.ebay.manager.utils.ResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{resource}")
    public ResponseEntity<Response> addUser(@PathVariable("resource") String resource){
        if(StringUtils.isEmpty(resource)) throw new ApplicationException(ApplicationErrorCode.BAD_PARAMS);
        userService.checkResource(resource);
        return ResponseGenerator.genSuccessResult();
    }
}
