package com.hamrorestaurant.hamrorestaurant.controller;

import com.hamrorestaurant.hamrorestaurant.entity.UserInfoEntity;
import com.hamrorestaurant.hamrorestaurant.model.userInfo.UserInfo;
import com.hamrorestaurant.hamrorestaurant.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/userInfo")
public class UserInfoController {
@Autowired
    private UserInfoService user;
@GetMapping("/users")
public List<UserInfoEntity> getUserList(){
    return user.userInfoList();
}

@PostMapping("/addUser")
public String addUser(@RequestBody UserInfoEntity userInfo){
    return user.addUserInfo(userInfo);
}
@PostMapping("/updateUser/{userId}")
public UserInfoEntity updateUserByUserId(@RequestParam String userId, @RequestBody UserInfoEntity userInfo){
    return user.updateUserInfo(userId, userInfo);
}
@GetMapping("/findUser/{userId}")
public UserInfoEntity getUserInfoById(@RequestParam int userId){
    return user.getUserInfoById(userId);
}

}
