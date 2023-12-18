package com.hamrorestaurant.hamrorestaurant.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity(name="UserAddress")
@Table(name = "UserAddress")
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long addId;
    private String streetAdderss;
    private String city;
    private String state;
    private String zipCode;
    private String Country;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private UserInfoEntity userInfo;

}
