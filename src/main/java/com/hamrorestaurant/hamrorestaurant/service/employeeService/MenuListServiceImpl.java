package com.hamrorestaurant.hamrorestaurant.service.employeeService;

import com.hamrorestaurant.hamrorestaurant.entity.MenuItemPrice;
import com.hamrorestaurant.hamrorestaurant.model.drinks.Drinks;
import com.hamrorestaurant.hamrorestaurant.model.drinks.HardDrinks;
import com.hamrorestaurant.hamrorestaurant.model.drinks.SoftDrinks;
import com.hamrorestaurant.hamrorestaurant.model.drinks.Water;
import com.hamrorestaurant.hamrorestaurant.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class MenuListServiceImpl implements MenuListService {
    @Autowired
    private MenuItemRepository repo;
    @Override
    public String addMenu(MenuItemPrice item) {
        return null;
    }

    @Override
    public String updateMenuByName(String item) {
        return null;
    }

    @Override
    public String updateMenuById(String id) {
        return null;
    }

    @Override
    public String deleteMenuByName(String item) {
        return null;
    }

    @Override
    public String deleteMenuById(String id) {
        return null;
    }

    @Override
    public List<MenuItemPrice> getAllMenu() {
        return repo.findAll();
    }

    public Drinks drinks(){
        Drinks drinks = new Drinks();
        //List of hard drinks type
        List<HardDrinks> hardDrinksList = new ArrayList<>();
        hardDrinksList.add(HardDrinks.valueOfOrDefault("Whiskey"));
        hardDrinksList.add(HardDrinks.valueOfOrDefault("Beer"));
        hardDrinksList.add(HardDrinks.valueOfOrDefault("Rum"));
        drinks.setHardDrinks(hardDrinksList);
        //List of soft drinks type
        List<SoftDrinks> softDrinksList = Arrays.asList(SoftDrinks.valueOfOrDefault("Coke"),SoftDrinks.valueOfOrDefault("Fanta"), SoftDrinks.valueOfOrDefault("Sprite"), SoftDrinks.valueOfOrDefault("Pepsi"), SoftDrinks.valueOfOrDefault("MountainDew"));
        drinks.setSoftDrinks(softDrinksList);
        //List of water type
        List<Water> waterList = Arrays.asList(Water.valueOfOrDefault("BottleWater"), Water.valueOfOrDefault("TapWater"));
        drinks.setWater(waterList);
        return drinks;
    }
}
