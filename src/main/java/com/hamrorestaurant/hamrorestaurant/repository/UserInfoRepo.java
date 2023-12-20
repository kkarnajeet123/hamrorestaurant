package com.hamrorestaurant.hamrorestaurant.repository;

import com.hamrorestaurant.hamrorestaurant.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfoEntity, Integer> {
}