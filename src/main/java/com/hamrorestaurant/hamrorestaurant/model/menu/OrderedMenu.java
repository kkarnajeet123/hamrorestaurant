package com.hamrorestaurant.hamrorestaurant.model.menu;

import lombok.Data;

@Data
public class OrderedMenu {


    private String itemName;
    private int count;

    public OrderedMenu(){

    }
    public OrderedMenu(String itemName, int count){
        this.count=count;
        this.itemName=itemName;
    }

}
