package com.hamrorestaurant.hamrorestaurant.model.menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderedMenu {


    private String itemName;
    private int count;
}
