package com.hamrorestaurant.hamrorestaurant.repository;

import com.hamrorestaurant.hamrorestaurant.entity.MenuItemPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItemPrice, Long> {
    MenuItemPrice findByItemName(String itemName);
    List<MenuItemPrice> findByCategory(String category);
    List<MenuItemPrice> findByMenuItem(String menuName);
}
