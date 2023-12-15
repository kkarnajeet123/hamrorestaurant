package com.hamrorestaurant.hamrorestaurant.entity;

import lombok.Data;

import javax.persistence.*;

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

    public String getStreetAdderss() {
        return streetAdderss;
    }

    public void setStreetAdderss(String streetAdderss) {
        this.streetAdderss = streetAdderss;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}
