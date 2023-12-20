package com.hamrorestaurant.hamrorestaurant.controller;

import com.hamrorestaurant.hamrorestaurant.entity.UserInfoEntity;
import com.hamrorestaurant.hamrorestaurant.service.UserInfoServiceImpl;
import com.hamrorestaurant.hamrorestaurant.web.rest.ErrorResponse;
import com.hamrorestaurant.hamrorestaurant.web.rest.UserInfoResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userInfo")
public class UserInfoController {
    @Autowired
    private UserInfoServiceImpl user;
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request. Missing required parameters", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class),
            @ApiResponse(code = 200, message = "Array of Lines", response = UserInfoResponse.class)})
    @RequestMapping(value="/users", produces = {"application/json"}, method= RequestMethod.GET)
    public UserInfoResponse getUserList() {
        return user.userInfoList();
    }

    @ApiOperation(
            value = "Get lines by accountId", notes = "Get mobile lines of service in the specified user account", response = String.class, tags = {"UserInfo",})

    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request. Missing required parameters", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class),
            @ApiResponse(code = 200, message = "Array of Lines", response = UserInfoResponse.class)})
    @RequestMapping(value = "/addUser", produces = {"application/json"}, method = RequestMethod.POST)
    public String addUser(@RequestBody UserInfoEntity userInfo) {
        return user.addUserInfo(userInfo);
    }

    @PostMapping("/updateUser/{userId}")
    public UserInfoEntity updateUserByUserId(@RequestParam String userId, @RequestBody UserInfoEntity userInfo) {
        return user.updateUserInfo(userId, userInfo);
    }

    @GetMapping("/findUser/{userId}")
    public UserInfoEntity getUserInfoById(@RequestParam int userId) {
        return user.getUserInfoById(userId);
    }

}
