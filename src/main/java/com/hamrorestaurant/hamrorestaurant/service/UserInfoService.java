package com.hamrorestaurant.hamrorestaurant.service;

import com.hamrorestaurant.hamrorestaurant.entity.UserInfoEntity;
import com.hamrorestaurant.hamrorestaurant.model.userInfo.UserInfo;
import com.hamrorestaurant.hamrorestaurant.repository.AddressRepo;
import com.hamrorestaurant.hamrorestaurant.repository.UserInfoRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository repo;

    @Autowired
    private AddressRepo addressRepo;

    public List<UserInfoEntity> userInfoList(){

//        UserInfo userInfo = new UserInfo();
//        userInfo.setUserId("1");
//        userInfo.setFirstName("Jack");
//        userInfo.setLastName("Jill");
//        StringBuilder stringBuilder = new StringBuilder();
//        userInfo.setEmailAddress("jj@gmail.com");
//        userInfo.setPhoneNumber(2134435090L);
//        //userInfo.getEmailAddress().toLowerCase();
//        List<UserInfo> userInfoList = Arrays.asList(userInfo);

        return repo.findAllUsers();

    }

    public String addUserInfo(UserInfoEntity userInfo){

//        UserInfo info = new UserInfo();
//        info.setFirstName(userInfo.getFirstName());
//        info.setLastName(userInfo.getLastName());
//        info.setPhoneNumber(userInfo.getPhoneNumber());
//        info.setEmailAddress(userInfo.getEmailAddress());
//        info.setAddress(userInfo.getAddress());
        repo.saveOrUpdate(userInfo);
        //repo.saveAndFlush(userInfo);
        //addressRepo.save(userInfo.getUseraddress());
        return "Record has been Saved!!!";
    }

    public UserInfoEntity updateUserInfo(String userId, UserInfoEntity userInfo){

    UserInfoEntity user = repo.findUserById(Integer.parseInt(userId));
    if(!ObjectUtils.isEmpty(user)){
        user.setEmailAddress(userInfo.getEmailAddress());
        user.setLastName(userInfo.getLastName());
        user.setFirstName(userInfo.getFirstName());
        user.setPhoneNumber(userInfo.getPhoneNumber());
        user.setUserAddress(userInfo.getUserAddress());
    }
       repo.saveOrUpdate(user);
        return user;
    }

    public UserInfoEntity getUserInfoById(int userId) {
        UserInfoEntity userInfo= repo.findUserById(userId);
    return userInfo;
    }
}
