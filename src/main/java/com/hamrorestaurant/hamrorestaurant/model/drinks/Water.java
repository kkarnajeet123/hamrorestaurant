package com.hamrorestaurant.hamrorestaurant.model.drinks;

public enum Water {

    BottleWater("bottleWater"), TapWater("tapWater");

    private final String water;

    Water(String water){
        this.water=water;
    }

    @Override
    public String toString() {
        return water;
    }

    public static Water valueOfOrDefault(String myvalue){
        for(Water type: Water.class.getEnumConstants()){
            if(type.toString().equalsIgnoreCase(myvalue)){
                return type;
            }
        }
        throw new IllegalArgumentException("Water is not available");
    }
}
