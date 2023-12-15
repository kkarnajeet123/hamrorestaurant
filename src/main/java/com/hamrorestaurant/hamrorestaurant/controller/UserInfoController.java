package com.hamrorestaurant.hamrorestaurant.controller;

import com.hamrorestaurant.hamrorestaurant.model.userInfo.UserInfo;
import com.hamrorestaurant.hamrorestaurant.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/userInfo")
public class UserInfoController {
@Autowired
    private UserInfoService user;
@GetMapping("/users")
public List<UserInfo> getUserList(){
    return user.userInfoList();
}

}
