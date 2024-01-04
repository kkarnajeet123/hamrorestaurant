package com.hamrorestaurant.hamrorestaurant.model.menu;

import com.hamrorestaurant.hamrorestaurant.model.drinks.Drinks;
import lombok.Data;

import java.util.List;
@Data
public class MenuItems {

//    private List<Drinks> drinks;
//    private Apettizer appetizerMenu;
//    private Lunch lunchMenu;
//    private Dinner dinnerMenu;
//    private Deserts desertsMenu;
    private List<String> drinks;
    private List<String> appetizers;
    private List<String> dinner;
    private List<String> deserts;

}
