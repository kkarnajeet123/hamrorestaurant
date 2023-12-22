package com.hamrorestaurant.hamrorestaurant.service;

import com.hamrorestaurant.hamrorestaurant.entity.UserAddress;
import com.hamrorestaurant.hamrorestaurant.entity.UserInfoEntity;
<<<<<<< HEAD
import com.hamrorestaurant.hamrorestaurant.model.userInfo.UserInfo;
=======
>>>>>>> origin/Task-AddingRepository
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

<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> origin/Task-AddingRepository
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
<<<<<<< HEAD
public class UserInfoServiceImpl implements UserInfoService {
=======
public class UserInfoServiceImpl {
>>>>>>> origin/Task-AddingRepository

    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);
    @Autowired
    private UserInfoRepo repo;

    @Autowired
    private AddressRepo addressRepo;
<<<<<<< HEAD
    @Autowired
    private UserInfoResponse userInfoResponse;

//    public UserInfoResponse userInfoList() {
//
//        List<UserInfoEntity> userList = repo.findAll();
//        UserInfoResponse response = new UserInfoResponse();
//        response.setData(userList);
//        return response;
//
//    }

//    public UserInfoResponse addUserInfo(UserInfoEntity userInfo) {
//        UserInfoResponse response = new UserInfoResponse();
//        try {
//            UserInfoEntity userInfoEntity = repo.findByEmailAddress(userInfo.getEmailAddress());
//            logger.info("The address is: ".concat(userInfo.getUserAddress().get(0).getStreetAdderss()));
//
//            UserInfoEntity availableRecords = repo.findById(userInfo.getUserId()).orElse(null);
//
//            if (ObjectUtils.isEmpty(availableRecords) && ObjectUtils.isEmpty(userInfoEntity)) {
//                repo.save(userInfo);
//            }
//        } catch (Exception e) {
//            //  throw new RuntimeException("Records already available!!", e);
//            List<Object> errorList = new ArrayList<>();
//            errorList.add("Records already available!!");
//            response.setError(errorList);
//            return response;
//
//        }
//        response.setData("Record has been Saved!!!");
//        return response;
//    }

//    public UserInfoEntity updateUserInfo(String userId, UserInfoEntity userInfo) {
//
//        UserInfoEntity user = repo.findById(Integer.parseInt(userId)).get();
//        if (!ObjectUtils.isEmpty(user)) {
//            user.setEmailAddress(userInfo.getEmailAddress());
//            user.setLastName(userInfo.getLastName());
//            user.setFirstName(userInfo.getFirstName());
//            user.setPhoneNumber(userInfo.getPhoneNumber());
//            user.setUserAddress(userInfo.getUserAddress());
//        }
//        repo.save(user);
//        return user;
//    }

//    public UserInfoResponse getUserInfoById(int userId) {
//        UserInfoEntity userInfo = repo.findById(userId).get();
//        UserInfoResponse response = new UserInfoResponse();
//        response.setData(userInfo);
//        return response;
//    }

    @Override
    public UserInfoResponse getAlluserInfo() {
        List<UserInfoEntity> users = repo.findAll();
        this.userInfoResponse.setData(users);
        return this.userInfoResponse;
    }

    @Override
    public UserInfoResponse addUserInfo(UserInfoEntity userInfo) {
        UserInfoResponse response = new UserInfoResponse();
        try {
            UserInfoEntity userInfoEntity = repo.findByEmailAddress(userInfo.getEmailAddress());
            logger.info("The address is: ".concat(userInfo.getUserAddress().get(0).getStreetAdderss()));

            UserInfoEntity availableRecords = repo.findById(userInfo.getUserId()).orElse(null);

            if (ObjectUtils.isEmpty(availableRecords) && ObjectUtils.isEmpty(userInfoEntity)) {
                repo.save(userInfo);
            }
        } catch (Exception e) {
            //  throw new RuntimeException("Records already available!!", e);
            List<Object> errorList = new ArrayList<>();
            errorList.add("Records already available!!");
            response.setError(errorList);
            return response;

        }
        response.setData("Record has been Saved!!!");
        return response;
    }

    @Override
    public UserInfoResponse deleteUserById(String userId) {

        if (!StringUtils.isEmpty(userId)) {
            UserInfoEntity userInfo = repo.findById(Integer.parseInt(userId)).get();
            repo.delete(userInfo);
            this.userInfoResponse.setData("User Information have been deleted");
        } else {
            this.userInfoResponse.setData("User not available!!");
        }
        return this.userInfoResponse;
    }

    @Override
    public UserInfoResponse deleteUserByName(String userName) {
        return null;
    }

    @Override
    public UserInfoResponse updateUserById(String userId, UserInfoEntity userInfo) {
        UserInfoEntity user = repo.findById(Integer.parseInt(userId)).get();
        if (!ObjectUtils.isEmpty(user)) {
            user.setEmailAddress(userInfo.getEmailAddress());
            user.setLastName(userInfo.getLastName());
            user.setFirstName(userInfo.getFirstName());
            user.setPhoneNumber(userInfo.getPhoneNumber());
            user.setUserAddress(userInfo.getUserAddress());
        }
        repo.save(user);
        this.userInfoResponse.setData("UserInfo has been updated!!");
        return this.userInfoResponse;
    }

    @Override
    public UserInfoResponse updateUserByName(String userName) {
        return null;
    }

    @Override
    public UserInfoResponse getUserById(String userId) {
        UserInfoEntity userInfo = repo.findById(Integer.parseInt(userId)).get();
        UserInfoResponse response = new UserInfoResponse();
        response.setData(userInfo);
        return response;
    }

    @Override
    public UserInfoResponse getUserByName(String userName) {

        List<UserInfoEntity> userInfoList = repo.findByFirstName(userName);
        this.userInfoResponse.setData(userInfoList);
        return userInfoResponse;
=======

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
>>>>>>> origin/Task-AddingRepository
    }
}
