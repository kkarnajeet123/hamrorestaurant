package com.hamrorestaurant.hamrorestaurant.service.hibernate;

import com.hamrorestaurant.hamrorestaurant.entity.UserInfoEntity;
import com.hamrorestaurant.hamrorestaurant.repository.AddressRepo;
import com.hamrorestaurant.hamrorestaurant.repository.hibernate.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.List;

//@Service
public class UserInfoService implements UserInfoRepository{

    @Autowired
    private UserInfoRepository repo;

    @Override
    public void saveOrUpdate(UserInfoEntity userInfo) {

    }

    @Override
    public List<UserInfoEntity> findAllUsers() {
        return null;
    }

    @Override
    public UserInfoEntity findUserById(int userId) {
        return null;
    }

    @Override
    public List<UserInfoEntity> findByFirstName(String name) {
        return null;
    }
}
