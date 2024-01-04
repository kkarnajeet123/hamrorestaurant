package com.hamrorestaurant.hamrorestaurant.web.rest;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String emailAddress;
    private String password;

}
