package com.hamrorestaurant.hamrorestaurant.model.userInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {
    private String streetAdderss;
    private String city;
    private String state;
    private String zipCode;
    private String Country;
}
