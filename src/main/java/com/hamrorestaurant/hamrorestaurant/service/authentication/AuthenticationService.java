package com.hamrorestaurant.hamrorestaurant.service.authentication;

import com.hamrorestaurant.hamrorestaurant.entity.UserInfoEntity;
import com.hamrorestaurant.hamrorestaurant.repository.hibernate.UserInfoRepository;
import com.hamrorestaurant.hamrorestaurant.web.rest.CommonResponse;
import com.hamrorestaurant.hamrorestaurant.web.rest.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class AuthenticationService {
    @Autowired
    private UserInfoRepository repo;

    public CommonResponse authenticateUser(UserLoginRequest userLoginRequest) {
        CommonResponse response = new CommonResponse();
        if (!ObjectUtils.isEmpty(userLoginRequest)) {
            //finding user by their email address
            UserInfoEntity user = repo.findUserByEmailAddress(userLoginRequest.getEmailAddress());
            if (!ObjectUtils.isEmpty(user)) {
                if (user.getPassword().equalsIgnoreCase(userLoginRequest.getPassword())) {
                    response.setData(user);
                } else {
                    response.setData("Invalid password, please try with correct password!!");
                }
            } else {
                response.setData("Invalid username, please try with valid username!!");
            }
        }

        return response;
    }
}
