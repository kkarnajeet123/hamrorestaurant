package com.hamrorestaurant.hamrorestaurant.repository;

import com.hamrorestaurant.hamrorestaurant.entity.MenuItemPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItemPrice, Long> {
}
