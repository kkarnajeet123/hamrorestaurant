package com.hamrorestaurant.hamrorestaurant.model.drinks;

public enum SoftDrinks {
    Coke ("coke"), Fanta ("fanta"), Sprite ("sprite"), Pepsi ("pepsi"), MountainDew ("mountainDew");

    private final String softDrinks;

    SoftDrinks(String softDrinks){
        this.softDrinks=softDrinks;
    }

    @Override
    public String toString() {
        return softDrinks;
    }

    public static SoftDrinks valueOfOrDefault(String myvalue){
        for(SoftDrinks type: SoftDrinks.class.getEnumConstants()){
            if(type.toString().equalsIgnoreCase(myvalue)){
                return type;
            }
        }
        throw new IllegalArgumentException("Softdrinks not available");
    }
}
