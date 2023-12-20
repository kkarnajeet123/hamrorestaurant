package com.hamrorestaurant.hamrorestaurant.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity (name = "MenuItemTable")
@Table (name = "MenuItemTable")
public class MenuItemPrice {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private String itemName;
    private String description;
    private String category;
    private String price;
}
