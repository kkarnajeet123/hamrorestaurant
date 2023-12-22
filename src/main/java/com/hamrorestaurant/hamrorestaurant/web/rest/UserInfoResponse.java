package com.hamrorestaurant.hamrorestaurant.web.rest;

import com.hamrorestaurant.hamrorestaurant.entity.UserInfoEntity;
import lombok.Data;

import java.util.List;
@Data
public class UserInfoResponse {
    private Object Data;
    private List<Object> error;
    private List<Object> warning;
}
