package com.hamrorestaurant.hamrorestaurant.service.employeeService;

import com.hamrorestaurant.hamrorestaurant.entity.MenuItemPrice;
import com.hamrorestaurant.hamrorestaurant.model.drinks.Drinks;

import java.util.List;

public interface MenuListService {

    String addMenu(MenuItemPrice item);
    String updateMenuByName(String item);
    String updateMenuById(String id);
    String deleteMenuByName(String item);
    String deleteMenuById(String id);
    List<MenuItemPrice> getAllMenu();

    Drinks drinks();
}
