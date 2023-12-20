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
    private UserInfoServiceImpl userService;
    @ApiOperation(
            value = "Get all user information", notes = "Get All User Information", response = UserInfoResponse.class, tags = {"UserInfo",})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request. Missing required parameters", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class),
            @ApiResponse(code = 200, message = "Array of Lines", response = UserInfoResponse.class)})
    @RequestMapping(value="/users", produces = {"application/json"}, method= RequestMethod.GET)
    public UserInfoResponse getUserList() {
        return userService.getAlluserInfo();
    }

    @ApiOperation(
            value = "Add a new User", notes = "Add a New User Details", response = UserInfoResponse.class, tags = {"UserInfo",})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request. Missing required parameters", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class),
            @ApiResponse(code = 200, message = "Array of Lines", response = UserInfoResponse.class)})
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public UserInfoResponse addUser(@RequestBody UserInfoEntity userInfo) {
        return userService.addUserInfo(userInfo);
    }
    @ApiOperation(
            value = "Update User", notes = "Update user information searching by userId", response = UserInfoResponse.class, tags = {"UserInfo",})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request. Missing required parameters", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class),
            @ApiResponse(code = 200, message = "Array of Lines", response = UserInfoResponse.class)})
    @RequestMapping(value = "/updateUser/{userId}", method = RequestMethod.POST)
   // @PostMapping("/updateUser/{userId}")
    public UserInfoResponse updateUserByUserId(@RequestParam String userId, @RequestBody UserInfoEntity userInfo) {
        return userService.updateUserById(userId, userInfo);
    }
    @ApiOperation(
            value = "Get user by their userId", notes = "Find user by their id", response = UserInfoResponse.class, tags = {"UserInfo",})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request. Missing required parameters", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class),
            @ApiResponse(code = 200, message = "Array of Lines", response = UserInfoResponse.class)})
    @RequestMapping(value = "/findUser/{userId}", produces = {"application/json"}, method = RequestMethod.GET)
   // @GetMapping("/findUser/{userId}")
    public UserInfoResponse getUserInfoById(@RequestParam String userId) {
        return userService.getUserById(userId);
    }

}
