package com.ensah.examplan.controller;

import com.ensah.examplan.model.UserInfo;
import com.ensah.examplan.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;
    @PostMapping("/userInfo")
    public String addUserInfo(@RequestBody UserInfo userInfo){
         userInfoService.addUserInfo(userInfo);
         return "user added successfully";
    }
}
