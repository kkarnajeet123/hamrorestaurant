package com.hamrorestaurant.hamrorestaurant.controller;

import com.hamrorestaurant.hamrorestaurant.model.drinks.Drinks;
import com.hamrorestaurant.hamrorestaurant.model.menu.MenuItems;
import com.hamrorestaurant.hamrorestaurant.service.MenuListServiceImpl;
import com.hamrorestaurant.hamrorestaurant.web.rest.ErrorResponse;
import com.hamrorestaurant.hamrorestaurant.web.rest.UserInfoResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/menu/items/")
public class MenuController {

    @Autowired
    private MenuListServiceImpl menuListService;

    @GetMapping("/food")
    public List<String> getMenuItems(){
        List<String> menuList = Arrays.asList("Launch", "Dinner", "Breakfast", "Drinks", "Appetizer");
        return menuList;
    }
    @GetMapping("/drinks")
    public Drinks getDrinks(){
        return menuListService.drinks();
    }
    @ApiOperation(
            value = "Delete User by UserId", notes = "Delete user information searching by userId", response = UserInfoResponse.class, tags = {"UserInfo",})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request. Missing required parameters", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class),
            @ApiResponse(code = 200, message = "Array of Lines", response = UserInfoResponse.class)})
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addMenuItem(@RequestBody MenuItems menuItems){
        return "Menu has been added";
    }
}
