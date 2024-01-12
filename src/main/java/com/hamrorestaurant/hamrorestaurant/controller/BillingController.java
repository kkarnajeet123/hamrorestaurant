package com.hamrorestaurant.hamrorestaurant.controller;

import com.hamrorestaurant.hamrorestaurant.model.menu.OrderedMenu;
import com.hamrorestaurant.hamrorestaurant.service.menuService.BillingServiceImpl;
import com.hamrorestaurant.hamrorestaurant.web.rest.BillingRequest;
import com.hamrorestaurant.hamrorestaurant.web.rest.CommonResponse;
import com.hamrorestaurant.hamrorestaurant.web.rest.CustomerBillingResponse;
import com.hamrorestaurant.hamrorestaurant.web.rest.error.ErrorResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class BillingController {

    @Autowired
    private BillingServiceImpl billingService;

    @ApiOperation(
            value = "Save menu items", notes = "Save items", response = CommonResponse.class, tags = {"MenuItem",})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request. Missing required parameters", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class),
            @ApiResponse(code = 200, message = "Array of Lines", response = CommonResponse.class)})
    @RequestMapping(value = "/billing/show/{tableNumber}", method = RequestMethod.POST)

    public CommonResponse getCustomerBill( @RequestBody BillingRequest orderMenuList ) {
        return billingService.getCustomerBill(orderMenuList);
    }

    @ApiOperation(
            value = "Save menu items", notes = "Save items", response = CommonResponse.class, tags = {"Billing",})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request. Missing required parameters", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class),
            @ApiResponse(code = 200, message = "Array of Lines", response = CommonResponse.class)})
    @RequestMapping(value = "/billing/bill", method = RequestMethod.POST)

    public ResponseEntity<CommonResponse> getCustomerBillTest(@RequestBody BillingRequest orderMenuList) {
        CommonResponse response = billingService.getBill(orderMenuList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(
            value = "Save menu items", notes = "Save items", response = CommonResponse.class, tags = {"Billing",})
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request. Missing required parameters", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class),
            @ApiResponse(code = 200, message = "Array of Lines", response = CommonResponse.class)})
    @RequestMapping(value = "/billing/total", method = RequestMethod.POST)

    public ResponseEntity<CommonResponse> getCustomerTotalBill(@RequestBody BillingRequest orderMenuList) {
        CommonResponse response = billingService.getTotalBill(orderMenuList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
