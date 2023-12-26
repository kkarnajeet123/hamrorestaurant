package com.hamrorestaurant.hamrorestaurant.controller;

import com.hamrorestaurant.hamrorestaurant.model.drinks.Drinks;
import com.hamrorestaurant.hamrorestaurant.model.menu.RequestMenuItem;
import com.hamrorestaurant.hamrorestaurant.service.employeeService.MenuListServiceImpl;
import com.hamrorestaurant.hamrorestaurant.service.menuService.MenuServiceImpl;
import com.hamrorestaurant.hamrorestaurant.util.CommonResponse;
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
    private MenuServiceImpl menuService;

    @ApiOperation(
            value = "Get all menu list", notes = "Show all menu", response = CommonResponse.class, tags = {"MenuItem",})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request. Missing required parameters", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class),
            @ApiResponse(code = 200, message = "Array of Lines", response = CommonResponse.class)})
    @RequestMapping(value = "/items",produces ={"application/json"}, method = RequestMethod.GET)
    public List<String> getMenuItems(){
        List<String> menuList = Arrays.asList("Launch", "Dinner", "Breakfast", "Drinks", "Appetizer");
        return menuList;
    }
    @ApiOperation(
            value = "Get all drinks list", notes = "Show all drinks", response = CommonResponse.class, tags = {"MenuItem",})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request. Missing required parameters", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class),
            @ApiResponse(code = 200, message = "Array of Lines", response = CommonResponse.class)})
    @RequestMapping(value = "/drinks",produces ={"application/json"}, method = RequestMethod.GET)
    public Drinks getAllDrinks(){
        return null;
    }
    @ApiOperation(
            value = "Save menu items", notes = "Save items", response = CommonResponse.class, tags = {"MenuItem",})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request. Missing required parameters", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class),
            @ApiResponse(code = 200, message = "Array of Lines", response = CommonResponse.class)})
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CommonResponse addMenuItem(@RequestBody RequestMenuItem menuItems){
        return menuService.saveMenuItem(menuItems);
    }
    @ApiOperation(
            value = "Update menu items", notes = "Update items", response = CommonResponse.class, tags = {"MenuItem",})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request. Missing required parameters", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class),
            @ApiResponse(code = 200, message = "Array of Lines", response = CommonResponse.class)})
    @RequestMapping(value = "/update/menu/{name}", method = RequestMethod.PUT)
    public CommonResponse updateMenuByName(@RequestBody RequestMenuItem menuItems, @PathVariable String name){
        return menuService.updateMenuByName(menuItems, name);
    }

    @ApiOperation(
            value = "Update menu items", notes = "Update items", response = CommonResponse.class, tags = {"MenuItem",})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request. Missing required parameters", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class),
            @ApiResponse(code = 200, message = "Array of Lines", response = CommonResponse.class)})
    @RequestMapping(value = "/update/id/{itemId}", method = RequestMethod.PUT)
    public CommonResponse updateMenuById(@RequestBody RequestMenuItem menuItems, @PathVariable String itemId){
        return menuService.updateMenuById(menuItems, itemId);
    }
}
