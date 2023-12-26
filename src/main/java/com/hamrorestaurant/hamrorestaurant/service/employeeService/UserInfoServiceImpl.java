package com.hamrorestaurant.hamrorestaurant.service.employeeService;

import com.hamrorestaurant.hamrorestaurant.entity.UserInfoEntity;
import com.hamrorestaurant.hamrorestaurant.repository.AddressRepo;
import com.hamrorestaurant.hamrorestaurant.repository.UserInfoRepo;
import com.hamrorestaurant.hamrorestaurant.web.rest.UserInfoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInformationService {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);
    @Autowired
    private UserInfoRepo repo;

    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private UserInfoResponse userInfoResponse;

    @Override
    public UserInfoResponse getAllUserInfo() {
        UserInfoResponse resp = new UserInfoResponse();
        List<UserInfoEntity> users = repo.findAll();
        resp.setData(users);
            //this.userInfoResponse.setData(users);

       return resp;
    }

    @Override
    public UserInfoResponse addUserInfo(UserInfoEntity userInfo) {
        UserInfoResponse response = new UserInfoResponse();
        try {
            UserInfoEntity checkUserInfoByEmailAddress = repo.findByEmailAddress(userInfo.getEmailAddress());
         //   logger.info("The address is: ".concat(userInfo.getUserAddress().get(0).getStreetAdderss()));

            UserInfoEntity checkUserInfoByUserId = repo.findById(userInfo.getUserId()).orElse(null);

            logger.info("Adding user information in DB" + userInfo);
            if (ObjectUtils.isEmpty(checkUserInfoByEmailAddress) && ObjectUtils.isEmpty(checkUserInfoByUserId)) {
                // saving user information in User_Information Table
                repo.save(userInfo);

                // saving Address Table
//                UserAddress address = new UserAddress();
//                address.setUserInfo(userInfo);
//                address.setStreetAdderss(userInfo.getUserAddress().get(0).getStreetAdderss());
//                address.setCity(userInfo.getUserAddress().get(0).getCity());
//                address.setZipCode(userInfo.getUserAddress().get(0).getZipCode());
//                address.setCountry(userInfo.getUserAddress().get(0).getCountry());
//                address.setState(userInfo.getUserAddress().get(0).getState());
//                addressRepo.save(address);
            }

            logger.info("Showing userInfo after saving in DB");
            response.setData("User has been added");
        } catch (Exception e) {
            //  throw new RuntimeException("Records already available!!", e);
            List<Object> errorList = new ArrayList<>();
            errorList.add("Records already available!!");
            response.setError(errorList);
        }
        return response;
    }

    @Override
    public UserInfoResponse deleteUserById(String userId) {
        try {
            if (!StringUtils.isEmpty(userId)) {
                UserInfoEntity userInfo = repo.findById(Integer.parseInt(userId)).get();
                if (!ObjectUtils.isEmpty(userInfo)) {
                    repo.delete(userInfo);
                    this.userInfoResponse.setData("User Information have been deleted");
                }
            }
        } catch (Exception e) {
            List<Object> errorList = new ArrayList<>();
            errorList.add("User not available!!");
            this.userInfoResponse.setError(errorList);
        }
        return this.userInfoResponse;
    }

    @Override
    public UserInfoResponse deleteUserByEmailAddress(String emailAdderss) {
        try {
            if (!StringUtils.isEmpty(emailAdderss)) {
                UserInfoEntity userInfo = repo.findById(Integer.parseInt(emailAdderss)).get();
                if (!ObjectUtils.isEmpty(userInfo)) {
                    repo.delete(userInfo);
                    this.userInfoResponse.setData("User Information have been deleted");
                }
            }
        } catch (Exception e) {
            List<Object> errorList = new ArrayList<>();
            errorList.add("User not available with the emailAddress: ".concat(emailAdderss));
            this.userInfoResponse.setError(errorList);
        }
        return this.userInfoResponse;
    }

    @Override
    public UserInfoResponse updateUserById(String userId, UserInfoEntity userInfo) {
        try {
            if (!StringUtils.isEmpty(userId) && !ObjectUtils.isEmpty(userInfo)) {
                UserInfoEntity user = repo.findById(Integer.parseInt(userId)).get();
                if (!ObjectUtils.isEmpty(user)) {
                    repo.save(userInfo);
                    this.userInfoResponse.setData("UserInfo has been updated!!");
                }
            }
        } catch (Exception e) {
            List<Object> errorList = new ArrayList<>();
            errorList.add("UserInfo not available with the userId: " + userId);
            this.userInfoResponse.setError(errorList);
        }
        return this.userInfoResponse;
    }

    @Override
    public UserInfoResponse updateUserByEmailAddress(String emailAddress, UserInfoEntity userInfo) {
        try {
            if (!StringUtils.isEmpty(emailAddress) && !ObjectUtils.isEmpty(userInfo)) {
                UserInfoEntity user = repo.findByEmailAddress(emailAddress);
                if (!ObjectUtils.isEmpty(user)) {
                    repo.save(userInfo);
                    this.userInfoResponse.setData("UserInfo has been updated!!!");
                }
            }
        } catch (Exception e) {
            List<Object> errorList = new ArrayList<>();
            errorList.add("UserInfo not available with the emailAddress: " + emailAddress);
            this.userInfoResponse.setError(errorList);
        }
        return this.userInfoResponse;
    }

    @Override
    public UserInfoResponse getUserById(String userId) {
        try{
            if(!StringUtils.isEmpty(userId)){
                UserInfoEntity userInfo = repo.findById(Integer.parseInt(userId)).get();
                if(!ObjectUtils.isEmpty(userInfo)){
                    this.userInfoResponse.setData(userInfo);
                }
            }
        }catch (Exception e){
            List<Object> errorList = new ArrayList<>();
            errorList.add("Unable to find userInfo by userId ".concat(userId));
            this.userInfoResponse.setError(errorList);
        }
        return this.userInfoResponse;
    }

    @Override
    public UserInfoResponse getUserByEmailAddress(String emailAddress) {
        try {
            if (!StringUtils.isEmpty(emailAddress)) {
                UserInfoEntity user = repo.findByEmailAddress(emailAddress);
                if (!ObjectUtils.isEmpty(user)) {
                    repo.delete(user);
                    this.userInfoResponse.setData("User has been deleted!!!");
                }
            }
        } catch (Exception e) {
            List<Object> errorList = new ArrayList<>();
            errorList.add("UserInfo not available!!!");
            this.userInfoResponse.setError(errorList);
        }
        return this.userInfoResponse;
    }
}
