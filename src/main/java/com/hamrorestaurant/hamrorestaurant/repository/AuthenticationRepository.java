package com.hamrorestaurant.hamrorestaurant.repository;

import com.hamrorestaurant.hamrorestaurant.entity.UserAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepository extends JpaRepository<UserAuthentication, Long> {

}
