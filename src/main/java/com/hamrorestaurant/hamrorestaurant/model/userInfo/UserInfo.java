package com.hamrorestaurant.hamrorestaurant.model.userInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.hamrorestaurant.hamrorestaurant.entity.UserAddress;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfo {
    private String firstName;
    private String lastName;
    private List<Address> Address;
    private long phoneNumber;
    private String emailAddress;
}
