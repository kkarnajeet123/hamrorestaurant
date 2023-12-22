package com.hamrorestaurant.hamrorestaurant.repository;

import com.hamrorestaurant.hamrorestaurant.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfoEntity, Integer> {

    UserInfoEntity findByEmailAddress(String emailAddress);
    List<UserInfoEntity> findByFirstName(String name);
}
