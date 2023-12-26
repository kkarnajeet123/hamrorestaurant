package com.hamrorestaurant.hamrorestaurant.controller;

import com.hamrorestaurant.hamrorestaurant.entity.UserInfoEntity;
import com.hamrorestaurant.hamrorestaurant.service.employeeService.UserInfoServiceImpl;
import com.hamrorestaurant.hamrorestaurant.web.rest.ErrorResponse;
import com.hamrorestaurant.hamrorestaurant.web.rest.UserInfoResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/hibernate")
public class UserInformationController {
    private static final Logger logger = LoggerFactory.getLogger(UserInformationController.class);
    @Autowired
    private UserInfoServiceImpl userService;
    @ApiOperation(
            value = "Get all user information", notes = "Get All User Information", response = UserInfoResponse.class, tags = {"UserInfo-Hibernate",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = UserInfoResponse.class),
            @ApiResponse(code = 400, message = "Bad Request. Missing required parameters", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class)
    })
    @RequestMapping(value="/users", produces = {"application/json"}, method= RequestMethod.GET)
    public ResponseEntity<?> getUserList() {

        UserInfoResponse response= userService.getAllUserInfo();
        logger.info("Checking userInfo object: "+response.getData().toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @ApiOperation(
            value = "Get user by their userId", notes = "Find user by their id", response = UserInfoResponse.class, tags = {"UserInfo-Hibernate",})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request. Missing required parameters", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class),
            @ApiResponse(code = 200, message = "Array of Lines", response = UserInfoResponse.class)})
    @RequestMapping(value = "/findUser/{userId}", produces = {"application/json"}, method = RequestMethod.GET)
    // @GetMapping("/findUser/{userId}")
    public ResponseEntity<UserInfoResponse> getUserInfoById(@RequestParam String userId) {
        UserInfoResponse response= userService.getUserById(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(
            value = "Add a new User", notes = "Add a New User Details", response = UserInfoResponse.class, tags = {"UserInfo-Hibernate",})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request. Missing required parameters", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class),
            @ApiResponse(code = 200, message = "Array of Lines", response = UserInfoResponse.class)})
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<UserInfoResponse> addUser(@RequestBody UserInfoEntity userInfo) {
        UserInfoResponse response= userService.addUserInfo(userInfo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(
            value = "Update User by UserId", notes = "Update user information searching by userId", response = UserInfoResponse.class, tags = {"UserInfo-Hibernate",})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request. Missing required parameters", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class),
            @ApiResponse(code = 200, message = "Array of Lines", response = UserInfoResponse.class)})
    @RequestMapping(value = "/updateUser/{userId}", method = RequestMethod.PUT)
    // @PostMapping("/updateUser/{userId}")
    public ResponseEntity<UserInfoResponse> updateUserByUserId(@RequestParam String userId, @RequestBody UserInfoEntity userInfo) {
        UserInfoResponse response= userService.updateUserById(userId, userInfo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(
            value = "Update User by EmailAddress", notes = "Update user information searching by emailAddress", response = UserInfoResponse.class, tags = {"UserInfo-Hibernate",})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request. Missing required parameters", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class),
            @ApiResponse(code = 200, message = "Array of Lines", response = UserInfoResponse.class)})
    @RequestMapping(value = "/updateUser/{emailAddress}", method = RequestMethod.PUT)
    public ResponseEntity<UserInfoResponse> updateUserByEmailAddress(@RequestParam String emailAddress, @RequestBody UserInfoEntity userInfo) {
        UserInfoResponse response= userService.updateUserByEmailAddress(emailAddress, userInfo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(
            value = "Delete User by EmailAddress", notes = "Delete user information searching by emailAddress", response = UserInfoResponse.class, tags = {"UserInfo-Hibernate",})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request. Missing required parameters", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class),
            @ApiResponse(code = 200, message = "Array of Lines", response = UserInfoResponse.class)})
    @RequestMapping(value = "/updateUser/{emailAddress}", method = RequestMethod.DELETE)
    public ResponseEntity<UserInfoResponse> deleteUserByEmailAddress(@RequestParam String emailAddress) {
        UserInfoResponse response = userService.deleteUserByEmailAddress(emailAddress);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(
            value = "Delete User by UserId", notes = "Delete user information searching by userId", response = UserInfoResponse.class, tags = {"UserInfo-Hibernate",})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request. Missing required parameters", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class),
            @ApiResponse(code = 200, message = "Array of Lines", response = UserInfoResponse.class)})
    @RequestMapping(value = "/updateUser/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<UserInfoResponse> deleteUserByUserId(@RequestParam String userId) {
        UserInfoResponse response = userService.deleteUserById(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
