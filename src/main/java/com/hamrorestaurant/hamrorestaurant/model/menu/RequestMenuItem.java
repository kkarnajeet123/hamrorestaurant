package com.hamrorestaurant.hamrorestaurant.model.menu;

import lombok.Data;

@Data
public class RequestMenuItem {

    private String itemName;
    private String itemDescription;
    private String menuName;
    private String price;
    private String category;
}
