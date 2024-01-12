package com.hamrorestaurant.hamrorestaurant.service.menuService.gateway;

import com.hamrorestaurant.hamrorestaurant.model.menu.OrderedMenu;
import com.hamrorestaurant.hamrorestaurant.service.menuService.BillingServiceImpl;
import com.hamrorestaurant.hamrorestaurant.service.menuService.MenuServiceImpl;
import com.hamrorestaurant.hamrorestaurant.web.rest.BillingRequest;
import com.hamrorestaurant.hamrorestaurant.web.rest.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.Map;


public class BillerGatewayService {
    @Autowired
    private BillingServiceImpl billingService;


    public Map<String, Double> getCustomerBills( BillingRequest billingRequest){
//Make async call

        List<OrderedMenu> orderedMenuList=billingRequest.getMenu();


        CommonResponse billAmountOfEachItem= billingService.getBill(billingRequest);

        CommonResponse totalBillAmount= billingService.getCustomerBill(billingRequest);

       Object s= totalBillAmount.getData();
        billAmountOfEachItem.getData();
        return null;
    }
}
