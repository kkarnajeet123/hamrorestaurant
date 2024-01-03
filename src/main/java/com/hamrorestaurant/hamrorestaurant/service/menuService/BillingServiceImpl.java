package com.hamrorestaurant.hamrorestaurant.service.menuService;

import com.hamrorestaurant.hamrorestaurant.model.menu.OrderedMenu;
import com.hamrorestaurant.hamrorestaurant.web.rest.BillingRequest;
import com.hamrorestaurant.hamrorestaurant.web.rest.CommonResponse;
import com.hamrorestaurant.hamrorestaurant.web.rest.CustomerBillingResponse;
import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class BillingServiceImpl implements BillingService {

    private static final Logger logger = LoggerFactory.getLogger(BillingServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public CommonResponse getCustomerBill(int tableNumber, List<OrderedMenu> orderMenu) {
        CommonResponse response = new CommonResponse();
        ResponseEntity<CommonResponse> responseEntity = null;
//CustomerBillingResponse
        String url = "http://localhost:8071/customer/billing/getTotalPriceForEachItem";

        BillingRequest request = new BillingRequest();
        request.setTableNumber(tableNumber);
        request.setMenu(orderMenu);

        HttpEntity<Object> entity = new HttpEntity<>(request, httpHeaders());
        try {
            responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, CommonResponse.class);
        } catch (HttpServerErrorException e) {
            throw new RuntimeException("Unable to call endpoint" + e);
        }
        response.setData(responseEntity);
        return response;
    }

    @Override
    public CommonResponse getBill(int tableNumber, BillingRequest orderMenuList) {
        CommonResponse response = new CommonResponse();
        ResponseEntity<CustomerBillingResponse> responseEntity = null;
        String url = "http://localhost:8071/customer/billing/getTotalPriceForEachItem";
        logger.info("The request body for rest call is: " + orderMenuList);
        System.out.println(orderMenuList);
        HttpEntity<Object> entity = new HttpEntity<>(orderMenuList, httpHeaders());
        responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, CustomerBillingResponse.class);
        String responseJson = JSONArray.toJSONString(Arrays.asList(responseEntity));
        logger.info("The response from rest call is: " + responseEntity);
        System.out.println(responseJson);
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
}
