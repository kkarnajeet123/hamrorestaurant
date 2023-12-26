package com.hamrorestaurant.hamrorestaurant.service;

import com.hamrorestaurant.hamrorestaurant.entity.UserInfoEntity;
import com.hamrorestaurant.hamrorestaurant.web.rest.UserInfoResponse;
import com.hamrorestaurant.hamrorestaurant.web.rest.UserResponse;

import java.util.List;

public interface UserInformationService {
    UserInfoResponse getAllUserInfo();
    UserInfoResponse addUserInfo(UserInfoEntity userInfo);
    UserInfoResponse deleteUserById(String userId);
    UserInfoResponse deleteUserByEmailAddress(String emailAddress);
    UserInfoResponse updateUserById(String userId, UserInfoEntity userInfo);
    UserInfoResponse updateUserByEmailAddress(String emailAddress, UserInfoEntity userInfo);
    UserInfoResponse getUserById(String userId);
    UserInfoResponse getUserByEmailAddress(String emailAddress);
}
