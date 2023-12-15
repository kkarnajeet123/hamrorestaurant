package com.hamrorestaurant.hamrorestaurant.service;

import com.hamrorestaurant.hamrorestaurant.model.drinks.Drinks;
import com.hamrorestaurant.hamrorestaurant.model.drinks.HardDrinks;
import com.hamrorestaurant.hamrorestaurant.model.drinks.SoftDrinks;
import com.hamrorestaurant.hamrorestaurant.model.drinks.Water;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MenuListService {

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
