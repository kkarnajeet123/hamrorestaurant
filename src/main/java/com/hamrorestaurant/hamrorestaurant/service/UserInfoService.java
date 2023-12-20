package com.hamrorestaurant.hamrorestaurant.service;

import com.hamrorestaurant.hamrorestaurant.entity.UserInfoEntity;
import com.hamrorestaurant.hamrorestaurant.model.userInfo.UserInfo;
import com.hamrorestaurant.hamrorestaurant.web.rest.UserInfoResponse;

import java.util.List;

public interface UserInfoService {

    UserInfoResponse getAlluserInfo();
    UserInfoResponse addUserInfo(UserInfoEntity userInfo);
    UserInfoResponse deleteUserById(String userId);
    UserInfoResponse deleteUserByName(String userName);
    UserInfoResponse updateUserById(String userId, UserInfoEntity userInfo);
    UserInfoResponse updateUserByName(String userName);
    UserInfoResponse getUserById(String userId);
    UserInfoResponse getUserByName(String userName);
}
