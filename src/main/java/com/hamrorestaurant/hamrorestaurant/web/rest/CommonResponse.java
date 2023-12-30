package com.hamrorestaurant.hamrorestaurant.web.rest;

import lombok.Data;

import java.util.List;
@Data
public class CommonResponse {
    private Object data;
    private List<Object> error;
    private List<Object> warning;

    public CommonResponse(){

    }
    public CommonResponse(Object data){
        this.data = data;
    }
}
