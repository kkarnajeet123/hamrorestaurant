package com.hamrorestaurant.hamrorestaurant.controller;

import com.hamrorestaurant.hamrorestaurant.service.authentication.AuthenticationService;
import com.hamrorestaurant.hamrorestaurant.web.rest.CommonResponse;
import com.hamrorestaurant.hamrorestaurant.web.rest.UserInfoResponse;
import com.hamrorestaurant.hamrorestaurant.web.rest.UserLoginRequest;
import com.hamrorestaurant.hamrorestaurant.web.rest.error.ErrorResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class UserLoginController {

    @Autowired
    private AuthenticationService auth;


    @ApiOperation(
            value = "Validate user", notes = "Authenticate User", response = UserInfoResponse.class, tags = {"Login",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = UserInfoResponse.class),
            @ApiResponse(code = 400, message = "Bad Request. Missing required parameters", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class)
    })
    @RequestMapping(value="/user/login", produces = {"application/json"}, method= RequestMethod.GET)
    public CommonResponse checkValidUser(@RequestBody UserLoginRequest loginRequest) {

        return auth.authenticateUser(loginRequest);

    }
}
