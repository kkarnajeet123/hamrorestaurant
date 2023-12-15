package com.hamrorestaurant.hamrorestaurant.model.drinks;

public enum HardDrinks {

    Whiskey ("whiskey"), Rum("rum"), Beer("beer");
    private final String hardDrinks;


    HardDrinks (String drinks){
       this.hardDrinks=drinks;
   }


    @Override
    public String toString() {
        return hardDrinks;
    }

    public static HardDrinks valueOfOrDefault(String myvalue){
        for(HardDrinks type: HardDrinks.class.getEnumConstants()){
            if(type.toString().equalsIgnoreCase(myvalue)){
                return type;
            }
        }
        throw new IllegalArgumentException("HardDrinks not available");
    }
}
