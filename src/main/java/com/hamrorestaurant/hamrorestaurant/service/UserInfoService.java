package com.hamrorestaurant.hamrorestaurant.service;

import com.hamrorestaurant.hamrorestaurant.entity.UserInfoEntity;
import com.hamrorestaurant.hamrorestaurant.model.userInfo.UserInfo;
import com.hamrorestaurant.hamrorestaurant.web.rest.UserInfoResponse;

import java.util.List;

public interface UserInfoService {

    UserInfoResponse getAlluserInfo();
    String addUserInfo(UserInfo userInfo);
    String deleteUserById(String userId);
    String deleteUserByName(String userName);
    String updateUserById(String userId);
    String updateUserByName(String userName);
    UserInfoEntity getUserById(String userId);
    UserInfoEntity getUserByName(String userName);
}
