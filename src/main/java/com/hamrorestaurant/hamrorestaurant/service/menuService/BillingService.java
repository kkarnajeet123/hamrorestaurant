package com.hamrorestaurant.hamrorestaurant.service.menuService;

import com.hamrorestaurant.hamrorestaurant.model.menu.OrderedMenu;
import com.hamrorestaurant.hamrorestaurant.web.rest.BillingRequest;
import com.hamrorestaurant.hamrorestaurant.web.rest.CommonResponse;

import java.util.List;

public interface BillingService {

    CommonResponse getCustomerBill(BillingRequest orderMenuList);
    CommonResponse getBill(BillingRequest orderMenuList);

    CommonResponse getTotalBill(BillingRequest orderMenuList);
}
