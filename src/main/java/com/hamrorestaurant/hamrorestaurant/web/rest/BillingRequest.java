package com.hamrorestaurant.hamrorestaurant.web.rest;

import com.hamrorestaurant.hamrorestaurant.model.menu.OrderedMenu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingRequest {
    private int tableNumber;
    private List<OrderedMenu> menu;
}
