package com.hamrorestaurant.hamrorestaurant.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity (name = "MenuItemTable")
@Table (name = "MenuItemTable", schema = "dbo")
public class MenuItemPrice {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private long id;
    private String itemName;
    private String description;
    private String category;
    private String price;
    private String menuItem;
}
