package com.hamrorestaurant.hamrorestaurant.service.menuService;

import com.hamrorestaurant.hamrorestaurant.model.menu.OrderedMenu;
import com.hamrorestaurant.hamrorestaurant.web.rest.BillingRequest;
import com.hamrorestaurant.hamrorestaurant.web.rest.CommonResponse;
import com.hamrorestaurant.hamrorestaurant.web.rest.CustomerBillingResponse;
import com.hamrorestaurant.hamrorestaurant.web.rest.CustomerBillingTotalCostResponse;
import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BillingServiceImpl implements BillingService {

    private static final Logger logger = LoggerFactory.getLogger(BillingServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public CommonResponse getCustomerBill(BillingRequest orderMenuList) {
        CommonResponse response = new CommonResponse();
        ResponseEntity<CommonResponse> responseEntity = null;
//CustomerBillingResponse
        Map<String, Integer> queryBuilder = new HashMap<>();
        int tableNumber = orderMenuList.getTableNumber();
        String url = "http://BILLING-SERVICE/api/customer/billing/getTotalPriceForEachItem?tableNumber={tableNumber}";
        HttpEntity<Object> entity = new HttpEntity<>(orderMenuList, httpHeaders());
        try {
            responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, CommonResponse.class, queryBuilder);
        } catch (HttpServerErrorException e) {
            throw new RuntimeException("Unable to call endpoint" + e);
        }
        response.setData(responseEntity);
        return response;
    }

    @Override
    public CommonResponse getBill(BillingRequest orderMenuList) {
        CommonResponse response = new CommonResponse();
        ResponseEntity<CustomerBillingResponse> responseEntity = null;
        Map<String, Integer> queryBuilder = new HashMap<>();
        int tableNumber = orderMenuList.getTableNumber();
        queryBuilder.put("tableNumber", tableNumber);
        String url = "http://BILLING-SERVICE/api/customer/billing/getTotalPriceForEachItem?tableNumber={tableNumber}";
        logger.info("The url is: " + url);
        logger.info("The request body for rest call is: " + orderMenuList);
        HttpEntity<Object> entity = new HttpEntity<>(orderMenuList, httpHeaders());
        try {
            responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, CustomerBillingResponse.class, queryBuilder);
        } catch (HttpServerErrorException e) {
            throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "Failing to get billing information!!");
        }
        String responseJson = JSONArray.toJSONString(Arrays.asList(responseEntity));
        logger.info("The response from rest call is: " + responseEntity);
        System.out.println(responseJson);
        response.setData(responseEntity.getBody());


        return response;
    }

    @Override
    public CommonResponse getTotalBill(BillingRequest orderMenuList) {

        CommonResponse response = new CommonResponse();
        ResponseEntity<CustomerBillingTotalCostResponse> responseEntity = null;
        Map<String, Integer> queryBuilder = new HashMap<>();
        int tableNumber = orderMenuList.getTableNumber();
        queryBuilder.put("tableNumber", tableNumber);
        String url = "http://BILLING-SERVICE/api/customer/billing/getTotalBillAmount?tableNumber={tableNumber}";

        List<OrderedMenu> orderList = orderMenuList.getMenu();
        logger.info("The request body is: "+orderList.toString());
        HttpEntity<Object> entity = new HttpEntity<>(orderMenuList, httpHeaders());

        try {
            responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, CustomerBillingTotalCostResponse.class, queryBuilder);
            logger.info("Received response from Biller: "+responseEntity.getBody().toString());
        } catch (HttpServerErrorException e) {
            throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "Failing to get billing information for total price");
        }

        response.setData(responseEntity.getBody());
        return response;

    }

    private HttpHeaders httpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        // headers.set("Accept", "application/json");
        headers.set("accept", "application/json");
        headers.set("Content-Type", "application/json");
        return headers;
    }

    private String practiceTernaryOperator() {
        boolean flag = false;
        return flag == true ? "true" : "false";

    }
}
