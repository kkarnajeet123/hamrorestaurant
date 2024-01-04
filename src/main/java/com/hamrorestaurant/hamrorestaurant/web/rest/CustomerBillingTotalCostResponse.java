package com.hamrorestaurant.hamrorestaurant.web.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerBillingTotalCostResponse {

    private int tableNumber;
    private double data;
    private List<Object> error;
    private List<Object> warnings;
}
