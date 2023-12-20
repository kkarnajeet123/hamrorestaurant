package com.hamrorestaurant.hamrorestaurant.service;

import com.hamrorestaurant.hamrorestaurant.entity.UserAddress;
import com.hamrorestaurant.hamrorestaurant.entity.UserInfoEntity;
import com.hamrorestaurant.hamrorestaurant.repository.AddressRepo;
import com.hamrorestaurant.hamrorestaurant.repository.UserInfoRepo;
import com.hamrorestaurant.hamrorestaurant.repository.UserInfoRepository;
import com.hamrorestaurant.hamrorestaurant.web.rest.UserInfoResponse;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserInfoServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);
    @Autowired
    private UserInfoRepo repo;

    @Autowired
    private AddressRepo addressRepo;

    public UserInfoResponse userInfoList(){

        List<UserInfoEntity> userList =repo.findAll();
        UserInfoResponse response = new UserInfoResponse();
        response.setData(userList);
        return response;

    }

    public String addUserInfo(UserInfoEntity userInfo){
        try {
        int givenUserId = userInfo.getUserId();
        logger.info("The address is: ".concat(userInfo.getUserAddress().get(0).getStreetAdderss()));

        UserInfoEntity availableRecords= repo.findById(givenUserId).orElse(null);

           if (ObjectUtils.isEmpty(availableRecords)) {
               repo.save(userInfo);
               return "Record has been Saved!!!";
           }
       }catch (Exception e){
        //   throw new RuntimeException("Records already available!!", e);
           throw e;
       }
        return "Record has been Saved!!!";
    }

    public UserInfoEntity updateUserInfo(String userId, UserInfoEntity userInfo){

    UserInfoEntity user = repo.findById(Integer.parseInt(userId)).get();
    if(!ObjectUtils.isEmpty(user)){
        user.setEmailAddress(userInfo.getEmailAddress());
        user.setLastName(userInfo.getLastName());
        user.setFirstName(userInfo.getFirstName());
        user.setPhoneNumber(userInfo.getPhoneNumber());
        user.setUserAddress(userInfo.getUserAddress());
    }
       repo.save(user);
        return user;
    }

    public UserInfoEntity getUserInfoById(int userId) {
        UserInfoEntity userInfo= repo.findById(userId).get();
    return userInfo;
    }
}
