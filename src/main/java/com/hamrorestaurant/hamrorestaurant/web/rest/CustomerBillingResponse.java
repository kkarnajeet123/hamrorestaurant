package com.hamrorestaurant.hamrorestaurant.web.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerBillingResponse {
    private int tableNumber;
    private Map<String, Double> data;
    private List<Object> error;
    private List<Object> warnings;

}
