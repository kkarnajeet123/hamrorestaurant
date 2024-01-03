package com.hamrorestaurant.hamrorestaurant.service.menuService;

import com.hamrorestaurant.hamrorestaurant.model.menu.OrderedMenu;
import com.hamrorestaurant.hamrorestaurant.web.rest.BillingRequest;
import com.hamrorestaurant.hamrorestaurant.web.rest.CommonResponse;

import java.util.List;

public interface BillingService {

    CommonResponse getCustomerBill(int tableNumber, List<OrderedMenu> orderMenu);
    CommonResponse getBill(int tableNumber, BillingRequest orderMenuList);
}
