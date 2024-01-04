package com.hamrorestaurant.hamrorestaurant.web.rest.error;

import lombok.Data;

@Data
public class CommonApplicationException extends RuntimeException{
    private String code;
    private String description;
    private Exception exception;

    public CommonApplicationException(String code, String description, Exception exception){
        this.code=code;
        this.description=description;
        this.exception=exception;
    }

    @Override
    public String toString() {
        return "CommonApplicationException{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", exception=" + exception +
                '}';
    }
}
