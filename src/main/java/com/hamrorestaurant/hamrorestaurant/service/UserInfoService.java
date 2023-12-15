package com.hamrorestaurant.hamrorestaurant.service;

import com.hamrorestaurant.hamrorestaurant.model.userInfo.UserInfo;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserInfoService {

    public List<UserInfo> userInfoList(){

        UserInfo userInfo = new UserInfo();
        userInfo.setFirstName("Jack");
        userInfo.setLastName("Jill");
        StringBuilder stringBuilder = new StringBuilder();
        userInfo.setEmailAddress("jj@gmail.com");
        userInfo.setPhoneNumber(2134435090L);
        //userInfo.getEmailAddress().toLowerCase();
        List<UserInfo> userInfoList = Arrays.asList(userInfo);

        return userInfoList;

    }
}
