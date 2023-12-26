package com.hamrorestaurant.hamrorestaurant.repository.hibernate;

import com.hamrorestaurant.hamrorestaurant.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface UserInfoRepository{

    public void saveOrUpdate(UserInfoEntity userInfo);
    public List<UserInfoEntity> findAllUsers();

    public UserInfoEntity findUserById(int userId);

    public List<UserInfoEntity> findByFirstName(String name);
}
