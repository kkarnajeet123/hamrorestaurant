package com.hamrorestaurant.hamrorestaurant.model.userInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfo {

    private String firstName;
    private String lastName;
    private Address Address;
    private long phoneNumber;
    private String emailAddress;
}
