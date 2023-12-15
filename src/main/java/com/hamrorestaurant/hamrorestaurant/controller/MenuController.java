package com.hamrorestaurant.hamrorestaurant.controller;

import com.hamrorestaurant.hamrorestaurant.model.drinks.Drinks;
import com.hamrorestaurant.hamrorestaurant.service.MenuListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MenuController {

    @Autowired
    private MenuListService menuListService;

    @GetMapping("/menu/items")
    public List<String> getMenuItems(){
        List<String> menuList = Arrays.asList("Launch", "Dinner", "Breakfast", "Drinks", "Appetizer");
        return menuList;
    }
    @GetMapping("/menu/items/drinks")
    public Drinks getDrinks(){
        return menuListService.drinks();
    }
}
