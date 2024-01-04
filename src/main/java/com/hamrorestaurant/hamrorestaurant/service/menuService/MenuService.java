package com.hamrorestaurant.hamrorestaurant.service.menuService;

import com.hamrorestaurant.hamrorestaurant.model.menu.RequestMenuItem;
import com.hamrorestaurant.hamrorestaurant.web.rest.CommonResponse;

public interface MenuService {
    CommonResponse saveMenuItem(RequestMenuItem menuItem);
    CommonResponse updateMenuByName(RequestMenuItem menuItem, String name);
    CommonResponse updateMenuById(RequestMenuItem menuItem, String id);

    CommonResponse deleteMenuById(String id);
    CommonResponse deleteMenuByName(String name);
    CommonResponse getAllMenu();
    CommonResponse getAllDrinks();
    CommonResponse getMenuById(String id);
    CommonResponse getMenuByName(String name);
    CommonResponse getDrinksById(String id);
    CommonResponse getDrinksByName(String name);

}
