package com.hamrorestaurant.hamrorestaurant.model.drinks;

import lombok.Data;

import java.util.List;
@Data
public class Drinks {
//@ApiModelProperty(value="softDrinks", dataType="String", example="Coke , Fanta, Sprite , Pepsi , MountainDew")
    private List<SoftDrinks> softDrinks;
    //@ApiModelProperty(value="hardDrinks", dataType="String", example="Whiskey , Rum, Beer")
    private List<HardDrinks> HardDrinks;
    //@ApiModelProperty(value="water", dataType="String", example="BottleWater , TapWater")
    private List<Water> water;


}
