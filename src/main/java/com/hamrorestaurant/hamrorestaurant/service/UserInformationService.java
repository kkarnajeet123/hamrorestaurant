package com.hamrorestaurant.hamrorestaurant.service;

import com.hamrorestaurant.hamrorestaurant.entity.UserInfoEntity;
import com.hamrorestaurant.hamrorestaurant.web.rest.UserInfoResponse;

public interface UserInformationService {
    UserInfoResponse getAlluserInfo();
    UserInfoResponse addUserInfo(UserInfoEntity userInfo);
    UserInfoResponse deleteUserById(String userId);
    UserInfoResponse deleteUserByName(String userName);
    UserInfoResponse updateUserById(String userId, UserInfoEntity userInfo);
    UserInfoResponse updateUserByName(String userName);
    UserInfoResponse getUserById(String userId);
    UserInfoResponse getUserByName(String userName);
}
